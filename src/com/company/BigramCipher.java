package com.company;

public class BigramCipher {
    int indexLine[]= new int[3];
    int indexColumn[]= new int[3];
    int thirdRuleIndex[]= new int[4];

    void Encryption(String message) {
        message = message.toUpperCase();
        message = message.replaceAll(" ", "");
        message = message.replaceAll("J", "I");
        char[][] aplhavit = new char[][]{{'A', 'B', 'C', 'D', 'E'},
                {'F', 'G', 'H', 'I', 'K'},
                {'L', 'M', 'N', 'O', 'P'},
                {'Q', 'R', 'S', 'T', 'U'},
                {'V', 'W', 'X', 'Y', 'Z'}};
        int len = message.length();

        if(message.length()%2==1){
            message = message + "A";
        }
        System.out.print("Зашифрований текст :");
        for(int i = 0; i < len; i+=2) {
            char b = message.charAt(i);
            char c = message.charAt(i+1);
            if (firstRule(b, c, aplhavit)) {
                System.out.print(" ");
                if(indexLine[0]==4) System.out.print(aplhavit[indexLine[2]][0]);
                else System.out.print(aplhavit[indexLine[2]][indexLine[0]+1]);

                if(indexLine[1]==4) System.out.print(aplhavit[indexLine[2]][0]);
                else System.out.print(aplhavit[indexLine[2]][indexLine[1]+1]);
            }else if(secondrule(b,c,aplhavit)){
                System.out.print(" ");
                if(indexColumn[0]==4) System.out.print(aplhavit[0][indexColumn[2]]);
                else System.out.print(aplhavit[indexColumn[0]+1][indexColumn[2]]);

                if(indexColumn[1]==4) System.out.print(aplhavit[0][indexColumn[2]]);
                else System.out.print(aplhavit[indexColumn[1]+1][indexColumn[2]]);
            }else{
                thirdRule(b,c,aplhavit);
                System.out.print(" ");
                System.out.print(aplhavit[thirdRuleIndex[0]][thirdRuleIndex[1]]);
                System.out.print(aplhavit[thirdRuleIndex[2]][thirdRuleIndex[3]]);
            }

        }

    }

    public boolean firstRule(char b, char c, char[][] arr){
        boolean flag1 = false, flag2 = false;
        for (int z = 0 ; z < 5;z++) {
            for (int i = 0; i < 5; i++) {
                if (arr[z][i] == b) {
                    flag1 = true;
                    indexLine[0] = i;
                    indexLine[2] = z;
                    for (int x = 0; x < 5; x++) {
                        if (arr[z][x] == c) {
                            flag2 = true;
                            indexLine[1] = x;
                            break;
                        }
                    }
                }
            }
        }
        if(flag1 && flag2)return true;
        else return false;
    }
    public boolean secondrule(char b,char c,char arr[][]){
        boolean flag1 = false, flag2 = false;
        int column=0;
        for(int i = 0; i<5;i++){
            for(int z = 0; z<5 ; z++){
                if(b==arr[i][z]){
                    flag1 = true;
                    column=z;
                    indexColumn[0]=i;
                    indexColumn[2]=column;
                    break;
                }
            }
        }
        for (int x = 0 ; x<5 ; x++){
            if(c==arr[x][column]){
                flag2 = true;
                indexColumn[1]=x;
                break;
            }
        }
        if(flag1 && flag2) return  true;
        else  return false;
    }

    public void thirdRule(char b, char c,char arr[][]){
        for(int line = 0;line<5;line++){
            for(int column = 0; column<5;column++){
                if(b==arr[line][column]){
                    thirdRuleIndex[0] = line;
                    thirdRuleIndex[3]=column;
                }
            }
        }
        for(int line = 0;line<5;line++){
            for(int column = 0; column<5;column++){
                if(c==arr[line][column]){
                    thirdRuleIndex[1] = column;
                    thirdRuleIndex[2]=line;
                }
            }
        }
    }
}
