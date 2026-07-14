public class Calculation {
    char[] strArray;
    int sybmolsNumber =0;
    public double total=0;
    public static boolean checkError(String str)
    {   int howManySucc=0;
        char[] symbols={'-','+','/','%','^','*',};
        for(char symbol: symbols)
        {
            if(str.charAt(0)==symbol || str.charAt(str.length()-1)==symbol)
            {
                return true;
            }

        }
        if(str.length()>1){
                for(int j=0;j<str.length()-1;j++){
                    for(char symbol: symbols)
                    {   if(str.charAt(j)=='='){
                        howManySucc++;
                    }
                        if(str.charAt(j)==symbol && str.charAt(j+1)==symbol){
                            return true;
                        }

                    }
                    if(howManySucc>1){
                        return true;
                    }
            }
        }

        return false;

    }
    public  void howManySymbol(String str)
    {
        strArray= str.toCharArray();
        sybmolsNumber =0;
        String symbols ="/*-+^%";
        for(int i=0; i<strArray.length;i++)
        {
            if(symbols.indexOf(strArray[i])!=-1)
            {
                sybmolsNumber+=1;

            }
        }
    }
    public double importNumber(char[] Array,int theNextPos)
    {
        String strNum="";
        if(theNextPos>0){
            theNextPos+=1;
        }
        for(int i=theNextPos; i<Array.length;i++)
        {
            if(Character.isDigit(Array[i])){
                strNum+=Array[i];

            }else{
                break;
            }
        }
        System.out.println(strNum);
        return Double.parseDouble(strNum);
    }
    public String getIndexOfEachSymbol(String str){
        String symbols ="/*-+^%";
        String IndexSymbols="";
        for(int i=0; i<str.length();i++)
        {
            if(symbols.indexOf(str.charAt(i))!=-1)
            {
                IndexSymbols+=(i+"-");

            }
        }
        return IndexSymbols.substring(0,IndexSymbols.length()-1);

    }
    public void findRightEquation(double number,char symbol){
        switch(symbol){
            case '+':
                this.total+=number;System.out.println("total="+total);
                break;
            case '-':
                this.total-=number;
                break;
            case '*':
                this.total*=number;
                break;
            case '/':
                if(number==0){
                    number=1;
                }
                this.total /= number;
                break;

            case '%':
                if(number==0){
                    number=1;
                }
                this.total %= number;
                break;
            case '^':
                this.total=Math.pow(this.total,number);

        }

    }
    public void calculation(String str,int symbolsNumber){
        strArray= str.toCharArray();
        String[] symbolsIndex = getIndexOfEachSymbol(str).split("-");
        double current_number=0;
        this.total=importNumber(strArray,0);
        for(int i=0 ; i<symbolsNumber;i++){
            current_number=importNumber(strArray,Integer.parseInt(symbolsIndex[i]));
            findRightEquation(current_number,str.charAt(Integer.parseInt(symbolsIndex[i])));
        }
        System.out.println("current_number ="+current_number);
        System.out.println("= "+getIndexOfEachSymbol(str));
    }


    public void mainCalculation(String str)
    {
        char currentSymbol=' ';

        if(!str.isEmpty())
        {
            if(checkError(str))
            {
                System.out.println("0");
            }
            else
            {

                this.howManySymbol(str);
                this.calculation(str,this.sybmolsNumber);
                System.out.println(this.total);
            }
        }
    }
}
