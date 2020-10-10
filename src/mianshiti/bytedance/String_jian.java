package mianshiti.bytedance;

/**
 * 字符串相减  不对  12345.789 - 3333675.32455
 * 只能算整数
 */
public class String_jian {

    public static String reduce(String str1,String str2){
        StringBuilder sb=new StringBuilder();
        if(str1==null ||str2==null){
            return sb.toString();
        }
        String s1=new StringBuilder(str1).reverse().toString();
        String s2=new StringBuilder(str2).reverse().toString();
        int len1=s1.length();
        int len2=s2.length();
        int max=len1>len2?len1:len2;
        if(len1>len2){
            for(int i=len2;i<max;i++){
                s2+="0";
            }
        }else{
            for(int i=len1;i<max;i++){
                s1+="0";
            }
        }
        int over=0;
        for(int i=0;i<max;i++){
            int sum=0;
            if(len1>len2){
                sum=s1.charAt(i)-'0'-(s2.charAt(i)-'0');
                sum+=over;
            }else{
                sum=s2.charAt(i)-'0'-(s1.charAt(i)-'0');
                sum+=over;
            }
            if(sum<0){
                over=-1;
                sb.append(10+sum);
            }else{
                over=0;
                sb.append(sum);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String reduce = reduce("10.0","2.1");
        System.out.println(reduce);
    }
}
