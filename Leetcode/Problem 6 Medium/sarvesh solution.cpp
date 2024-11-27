class Solution {
public:
    string convert(string s, int numRows) {
        
        //Base condition: If numRows = s.size() or Rows are 1
        if(numRows==s.size() || numRows==1)
        return s;

        int n = s.size();
        char zigzag [numRows][n];

        for(int i=0; i<numRows; i++){

            for(int j=0; j<n ; j++)
            zigzag[i][j] = '0';
        }

        bool dir = true;
        int i=0;
        int row = 0;
        int col = 0;

        while(i < s.size()){

            char ch = s[i];
            //Direction is downwards
            if(dir){

                if(row == numRows){
                    col++;
                    row-=2;
                    dir = false;
                }
                else{
                    zigzag[row][col] = ch;
                    row++;
                    i++;
                } 
            }
            else{

                if(row < 0){
                    row+=2;
                    col--;
                    dir = true;
                }
                else{

                    zigzag[row][col] = ch;
                    row--;
                    col++;
                    i++;
                }
            }
        }

        string ans = "";

        for(int i=0; i<numRows; i++){

            for(int j=0; j<n ; j++){
                
                if(zigzag[i][j] != '0')
                ans.push_back(zigzag[i][j]);
            }
        }
        return ans;
    }
};