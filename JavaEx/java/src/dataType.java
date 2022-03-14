public class dataType {
    public static void main(String[] args){
        byte byteNum = 100;//byte form -128 to 127(1byte)
        short shortNum = 5000;//short from -32768 to 32767(2bytes)
        int intNum = 100000;//int from -2147483648 to 2147483647(4 bytes)
        long longNum = 15000000000L;//longNum from -9223372036854775808 to 9223372036854775807(8 bytes)
        float floatNum = 5.75f; //from 3.4e−038 to 3.4e+038(4 bytes)
        double doubleNum = 19.99d;//from 1.7e−308 to 1.7e+308(8 bytes)
        boolean isJavaFun = true;
        boolean isFishTasty = false;
        char myGrade = 'B';
        char myVar1 = 65, myVar2 = 66, myVar3 = 67;//can use ASCII values to display certain characters
        String greeting = "Hello World";
        System.out.println(byteNum);
        System.out.println(shortNum);
        System.out.println(intNum);
        System.out.println(longNum);
        System.out.println(floatNum);
        System.out.println(doubleNum);
        System.out.println(isJavaFun);
        System.out.println(isFishTasty);
        System.out.println(myGrade);
        System.out.println(myVar1);
        System.out.println(myVar2);
        System.out.println(myVar3);
        System.out.println(greeting);
    }
}
