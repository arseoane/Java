public class Strings {
    public static void main(String[] args){
        String string1 = "abcdefg";
        System.out.println(string1.indexOf("b")); //1
        System.out.println(string1.lastIndexOf("h")); //-1 bc there is no h
        System.out.println(string1.charAt(3));//d

        String string2 = string1 + "hij";
        System.out.println(string2);
        string2 = string2 + 10; //abcdefghij10
        System.out.println(string2);

        string2 = string2.concat(Integer.toString(10)); //abcdefghij1010
        System.out.println(string2);

        System.out.println((char)string2.getBytes()[6]); //g
    }
}
