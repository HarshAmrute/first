import React, { useState } from 'react';

function App() {
  const [diceValue, setDiceValue] = useState(1);
  const [isRolling, setIsRolling] = useState(false);
  const [isDarkTheme, setIsDarkTheme] = useState(false);
  const [rollCount, setRollCount] = useState(0); // State to track the number of rolls

  const rollDice = () => {
    if (isRolling) return;
    setIsRolling(true);
    setRollCount(rollCount + 1); // Increment roll count

    const randomNumber = Math.floor(Math.random() * 6) + 1;

    setTimeout(() => {
      setDiceValue(randomNumber);
      setIsRolling(false);
    }, 1500);
  };

  const toggleTheme = () => {
    setIsDarkTheme(!isDarkTheme);
  };

  const getDiceFace = (value) => {
    const dots = [
      [],
      [<div className="dot"></div>],
      [<div className="dot top-left"></div>, <div className="dot bottom-right"></div>],
      [<div className="dot top-left"></div>, <div className="dot center"></div>, <div className="dot bottom-right"></div>],
      [<div className="dot top-left"></div>, <div className="dot top-right"></div>, <div className="dot bottom-left"></div>, <div className="dot bottom-right"></div>],
      [<div className="dot top-left"></div>, <div className="dot top-right"></div>, <div className="dot center"></div>, <div className="dot bottom-left"></div>, <div className="dot bottom-right"></div>],
      [<div className="dot top-left"></div>, <div className="dot top-right"></div>, <div className="dot middle-left"></div>, <div className="dot middle-right"></div>, <div className="dot bottom-left"></div>, <div className="dot bottom-right"></div>],
    ];
    return <div className="dice-face">{dots[value]}</div>;
  };

  return (
    <div className={`App ${isDarkTheme ? 'dark-theme' : 'light-theme'}`}>
      <div className="theme-toggle">
        <button onClick={toggleTheme}>
          {isDarkTheme ? 'Switch to Light Theme' : 'Switch to Dark Theme'}
        </button>
      </div>

      <div className="dice-container">
        <div className={`dice ${isRolling ? 'rolling' : ''}`}>
          <div className="dice-side front">{getDiceFace(diceValue)}</div>
          <div className="dice-side back">{getDiceFace(diceValue)}</div>
          <div className="dice-side left">{getDiceFace(diceValue)}</div>
          <div className="dice-side right">{getDiceFace(diceValue)}</div>
          <div className="dice-side top">{getDiceFace(diceValue)}</div>
          <div className="dice-side bottom">{getDiceFace(diceValue)}</div>
        </div>
      </div>

      <button onClick={rollDice} className="roll-button" disabled={isRolling}>
        {isRolling ? 'Rolling...' : 'Roll Dice'}
      </button>

      <div className="roll-count">Roll Count: {rollCount}</div>

      <style>{`
        .App {
          display: flex;
          justify-content: center;
          align-items: center;
          flex-direction: column;
          height: 100vh;
          font-family: 'Arial', sans-serif;
          transition: background-color 0.3s ease, color 0.3s ease;
        }

        .theme-toggle {
          margin-bottom: 20px;
        }

        button {
          padding: 10px 20px;
          font-size: 16px;
          background-color: #4CAF50;
          color: white;
          border: none;
          cursor: pointer;
          border-radius: 8px;
        }

        button:hover {
          background-color: #45a049;
        }

        .light-theme {
          background-color: #f7f7f7;
          color: #333;
        }

        .dark-theme {
          background-color: #333;
          color: white;
        }

        .dice-container {
          perspective: 1200px;
          margin-bottom: 30px;
        }

        .dice {
          width: 120px;
          height: 120px;
          position: relative;
          transform-style: preserve-3d;
          transform: rotateX(-30deg) rotateY(30deg);
          transition: transform 1s ease, box-shadow 0.3s ease;
        }

        .dice.rolling {
          animation: roll 1.5s infinite;
        }

        .dice-side {
          position: absolute;
          width: 120px;
          height: 120px;
          background-color: white;
          border: 2px solid #ccc;
          display: flex;
          justify-content: center;
          align-items: center;
          font-size: 30px;
          font-weight: bold;
          color: #333;
        }

        .front { transform: translateZ(60px); }
        .back { transform: rotateY(180deg) translateZ(60px); }
        .left { transform: rotateY(-90deg) translateZ(60px); }
        .right { transform: rotateY(90deg) translateZ(60px); }
        .top { transform: rotateX(90deg) translateZ(60px); }
        .bottom { transform: rotateX(-90deg) translateZ(60px); }

        .dot {
          width: 20px;
          height: 20px;
          background-color: black;
          border-radius: 50%;
        }

        .top-left { position: absolute; top: 10px; left: 10px; }
        .top-right { position: absolute; top: 10px; right: 10px; }
        .bottom-left { position: absolute; bottom: 10px; left: 10px; }
        .bottom-right { position: absolute; bottom: 10px; right: 10px; }
        .center { position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); }
        .middle-left { position: absolute; top: 50%; left: 10px; transform: translateY(-50%); }
        .middle-right { position: absolute; top: 50%; right: 10px; transform: translateY(-50%); }

        .roll-button {
          padding: 12px 24px;
          margin-top: 20px;
          background-color: #4CAF50;
          color: white;
          border: none;
          font-size: 18px;
          border-radius: 8px;
          cursor: pointer;
          transition: background-color 0.3s ease;
        }

        .roll-button:disabled {
          background-color: #ccc;
          cursor: not-allowed;
        }

        .roll-button:hover {
          background-color: #45a049;
        }

        .roll-count {
          margin-top: 20px;
          font-size: 18px;
          font-weight: bold;
        }

        @keyframes roll {
          0% { transform: translateY(-500px) rotateX(0deg) rotateY(0deg); box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2); }
          50% { transform: translateY(50px) rotateX(180deg) rotateY(180deg); box-shadow: 0 8px 40px rgba(0, 0, 0, 0.3); }
          100% { transform: translateY(0) rotateX(360deg) rotateY(360deg); box-shadow: 0 10px 50px rgba(0, 0, 0, 0.4); }
        }

        @media (max-width: 768px) {
          .dice {
            width: 100px;
            height: 100px;
          }

          .dice-side {
            width: 100px;
            height: 100px;
          }

          button {
            font-size: 14px;
          }
        }
      `}</style>
    </div>
  );
}

export default App;