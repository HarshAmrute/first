import pandas as pd
import json

def xlsx_to_json(input_file, output_file):
    # Load the Excel file
    df = pd.read_excel(input_file)

    # Initialize the JSON structure
    json_data = {"messages": []}

    # Iterate through the rows of the DataFrame
    for _, row in df.iterrows():
        # Assuming the Excel file has columns: 'role' and 'content'
        if 'role' in row and 'content' in row:
            message = {
                "role": row['role'],
                "content": row['content']
            }
            json_data["messages"].append(message)
        else:
            raise ValueError("The Excel file must contain 'role' and 'content' columns.")

    # Write the JSON data to the output file
    with open(output_file, 'w', encoding='utf-8') as f:
        json.dump(json_data, f, ensure_ascii=False, indent=4)

# Example usage
input_file = '/workspaces/first/Shaun/JD.xlsx'  # Path to the uploaded Excel file
output_file = 'output.json'  # Path for the JSON output file

xlsx_to_json(input_file, output_file)
print(f"JSON file has been created at: {output_file}")
