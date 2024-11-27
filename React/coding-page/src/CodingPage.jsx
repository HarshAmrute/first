import React, { useState } from 'react';
import { Controlled as CodeMirror } from '@uiw/react-codemirror';
import 'codemirror/lib/codemirror.css';
import 'codemirror/mode/javascript/javascript';

const CodingPage = () => {
  const [code, setCode] = useState('');
  const [output, setOutput] = useState('');
  const [input, setInput] = useState('');

  const handleRunCode = () => {
    try {
      const result = eval(code); // Eval for JavaScript
      setOutput(result);
    } catch (error) {
      setOutput("Error: " + error.message);
    }
  };

  return (
    <div className="coding-page">
      <div className="problem-statement">
        <h2>Problem Statement</h2>
        <p>Given an array, return the sum of its elements...</p>
      </div>

      <div className="editor-section">
        <h3>Code Editor</h3>
        <CodeMirror
          value={code}
          options={{
            mode: 'javascript',
            lineNumbers: true,
          }}
          onBeforeChange={(editor, data, value) => {
            setCode(value);
          }}
        />
      </div>

      <div className="input-output">
        <textarea
          placeholder="Enter input here..."
          value={input}
          onChange={(e) => setInput(e.target.value)}
        />
        <button onClick={handleRunCode}>Run Code</button>
        <div className="output">
          <h3>Output</h3>
          <pre>{output}</pre>
        </div>
      </div>
    </div>
  );
};

export default CodingPage;
