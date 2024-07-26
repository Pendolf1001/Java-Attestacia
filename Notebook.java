
import java.util.*;


public class Notebook
{
    String id;
    String ram;
    String name;
    String os;
    String hdd;
    int obRam;
    int obHdd;
    
    /**
     * Конструктор класса. создает поля ram,name, os,hdd,
     * id (генерируется случайным образом 4х значное число),
     * obRam и obHdd - генерируется на основе переданных строк обработанных
     * через функцию getOb()б данные поля нужны для проведения фильтрации 
     * по критериям <,> или =.
     */
     
    public Notebook(String ram, String name, String os, String hdd){
        Random r= new Random();
        this.id=Integer.toString(r.nextInt((9999 - 1000) + 1) + 1000);
        this.name=name;
        this.ram=ram;
        this.obRam=getOb(ram);
        this.os=os;
        this.hdd=hdd;
        this.obHdd=getOb(hdd);
    }
    
    /**
     * Функция из переданного парметра формирует значение для числовых
     * значений полей obRam и obHdd (объем ram и объем hdd).  
     */
     
    public static int getOb(String item){
        HashMap <String, Integer> edIsm=new HashMap<>();
        edIsm.put( "Gb",1);
        edIsm.put( "Tb",1024);
        
        String[] data = item.split(" ");
        String s=data[0];
        int ed=edIsm.get(data[1]);
        return (Integer.parseInt(s.trim()))*ed;
    }
    
   
    
    
    @Override
    public String toString(){
        return String.format("%s; ram: %s; %s; hdd: %s",this.name,this.ram, this.os, this.hdd );
    }
    
}


