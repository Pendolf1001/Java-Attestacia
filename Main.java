import java.util.*;


public class Main
{
    public static void main(String[] args) {
        ArrayList <Notebook> shop= new ArrayList <Notebook> ();
        ArrayList <Notebook> filter= new ArrayList <Notebook> ();
        generateNotebookShop(100, shop);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 Вывести весь список ноутбуков");
            System.out.println("2 Отфильровать по названию");
            System.out.println("3 Отфильровать по RAM");
            System.out.println("4 Отфильровать по ОС");
            System.out.println("5 Отфильровать по HDD");
            System.out.println("6 Выбор по критериям");
            System.out.println("7 Посмотреть что в фильтре");
            System.out.println("8 Очистить фильтр");
            System.out.println("q завершить программу");
            
            
            String n=sc.nextLine();
            if (n.equals("q")){
                break;
            }
            
            else if (n.equals("1")){
                showShop(shop);
            }
            
            else if (n.equals("2")){
                
                doFiltration("Name", filter,shop, sc);  
                
                
            }
            
            else if (n.equals("3")){
                
                doFiltration("RAM", filter,shop, sc);  
                
                

            }else if (n.equals("4")){
                doFiltration("OS", filter,shop, sc);  
                

                

            }else if (n.equals("5")){
                doFiltration("HDD", filter,shop, sc);  
                

                
                
            }else if (n.equals("8")){
                filter.clear();  
                
            }else if (n.equals("6")){
                getLimit(filter,shop, sc);
            }
            
            else if (n.equals("7")){
                
            }
            if (filter.isEmpty()){
                System.out.println("Фильтр пуст");
            }else{
                showShop(filter);
            }
        }
        System.out.println("Всего доброго!");
    }
    
    /**
     * Функция заполняет переданный список shop генерируемыми 
     * объектами Notebook в количествеб переданном при вызове функции (int col),
     * со случайными пармеметрами полейю.  
     */
     
    public static void generateNotebookShop (int col,ArrayList <Notebook> shop ){
        String ram;
        String name;
        String os;
        String hdd;
        Random n=new Random();
        for (int i=0; i<col; i++){
            name=getName(n.nextInt(7));
            ram=getRam(n.nextInt(6));
            os=getOS(n.nextInt(3));
            hdd=getHDD(n.nextInt(5));
            shop.add(new Notebook(ram,name,os,hdd));
            
        }
        System.out.println("Spisok sgeneririvan");
    }
     /**
     * Функция возвращает значение name из хэш таблицы
     * по переданному параметру int l.
     */
    public static String getName(int l){
        HashMap <Integer, String> names=new HashMap<>();
        names.put(1, "ASUS");
        names.put(2, "Acer");
        names.put(3, "Lenovo");
        names.put(4, "HP");
        names.put(0, "MainBenBen");
        names.put(5, "MSI");
        names.put(6, "Honor");
        String name=names.get(l);
        
        return name;
    }
    /**
     * Функция возвращает значение ram из хэш таблицы
     * по переданному параметру int l.
     */
    public static String getRam(int l){
        HashMap <Integer, String> rams=new HashMap<>();
        rams.put(1, "512 Gb");
        rams.put(2, "32 Gb");
        rams.put(3, "64 Gb");
        rams.put(4, "24 Gb");
        rams.put(0, "12 Gb");
        rams.put(5, "10 Gb");
        String ram=rams.get(l);
       
        return ram;
    }
    /**
     * Функция возвращает значение os из хэш таблицы
     * по переданному параметру int l.
     */
    public static String getOS(int l){
        HashMap <Integer, String> osS=new HashMap<>();
        osS.put(1, "Mac");
        osS.put(2, "Linux");
        osS.put(0, "Windows");
        String os=osS.get(l);
        return os;
    }
     /**
     * Функция возвращает значение hdd из хэш таблицы
     * по переданному параметру int l.
     */
    public static String getHDD(int l){
        HashMap <Integer, String> HDDs=new HashMap<>();
        HDDs.put(1, "256 Gb");
        HDDs.put(2, "512 Gb");
        HDDs.put(0, "1 Tb");
        HDDs.put(3, "2 Tb");
        HDDs.put(4, "128 Gb");
        String hdd=HDDs.get(l);
        return hdd;
    }
    /**
     * Процедура выводит строки в консоль с параметрами объектов из 
     * переданного листа с объектами Notebook.
     */
    public static void showShop( ArrayList <Notebook> shop){
        for (Notebook el:shop){
            System.out.println(el);
        }
    }
    /**
     * Процедура наполняет объектами Notebook, отобранными по 
     * указанным параметрам , списка filter. 
     */
    public static void doFiltration(String zapros,  ArrayList <Notebook> filter,
    ArrayList <Notebook> shop , Scanner sc){
        if (zapros.equals("Name")){
            HashMap <Integer, String> names=new HashMap<>();
            names.put(1, "ASUS");
            names.put(2, "Acer");
            names.put(3, "Lenovo");
            names.put(4, "HP");
            names.put(0, "MainBenBen");
            names.put(5, "MSI");
            names.put(6, "Honor");
            System.out.println("Введите брэнд ноутбука");
            System.out.println("0 - MainBenBen");
            System.out.println("1 - ASUS");
            System.out.println("2 - Acer");
            System.out.println("3 - Lenovo");
            System.out.println("4 - HP");
            System.out.println("5 - MSI");
            System.out.println("6 - Honor");

            int z =sc.nextInt();
            System.out.println("Vybrano" +z);
            String zaprosName=names.get(z);
            if (filter.isEmpty()){
               for (Notebook not: shop){
                    if (not.name==zaprosName){
                        filter.add(not);
                        System.out.println ("element "+not.name+" dobavlen");
                    }
                } 
            }else{
                Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                   Notebook nextNote = noteIterator.next();//получаем следующий элемент
                   if (!(nextNote.name.equals(zaprosName))) {
                       noteIterator.remove();//удаляем ноут с нужным именем
                   }
                }
            }
                
        }else if(zapros.equals("RAM")){
           HashMap <Integer, String> rams=new HashMap<>();
            rams.put(1, "512 Gb");
            rams.put(2, "32 Gb");
            rams.put(3, "64 Gb");
            rams.put(4, "24 Gb");
            rams.put(0, "12 Gb");
            rams.put(5, "10 Gb");
            System.out.println("Введите требуемый объем RAM");
            System.out.println("0 - 12 Gb");
            System.out.println("1 - 512 Gb");
            System.out.println("2 - 32 Gb");
            System.out.println("3 - 64 Gb");
            System.out.println("4 - 24 Gb");
            System.out.println("5 - 10 Gb");
            

            int z =sc.nextInt();
            System.out.println("Vybrano" +z);
            String zaprosRam=rams.get(z);
            if (filter.isEmpty()){
               for (Notebook not: shop){
                    if (not.ram==zaprosRam){
                        filter.add(not);
                        System.out.println ("element "+not.ram+" dobavlen");
                    }
                } 
            }else{
                Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                   Notebook nextNote = noteIterator.next();//получаем следующий элемент
                   if (!(nextNote.ram.equals(zaprosRam))) {
                       noteIterator.remove();//удаляем ноут с ненужным ram
                   }
                }
            }
        }else if(zapros.equals("OS")){
            HashMap <Integer, String> osS=new HashMap<>();
            osS.put(1, "Mac");
            osS.put(2, "Linux");
            osS.put(0, "Windows");
            System.out.println("Введите требуемую ОС");
            System.out.println("0 - Windows");
            System.out.println("1 - Mac OS");
            System.out.println("2 - Linux");
            
            int z =sc.nextInt();
            String zaprosRam=osS.get(z);
            if (filter.isEmpty()){
                for (Notebook not: shop){
                    if (not.os==zaprosRam){
                        filter.add(not);
                        System.out.println ("element "+not.os+" dobavlen");
                    }
                } 
            }else{
                Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                    Notebook nextNote = noteIterator.next();//получаем следующий элемент
                    if (!(nextNote.os.equals(zaprosRam))) {
                       noteIterator.remove();//удаляем ноут с ненужным ram
                    }
                }
            }
            
        }else if(zapros.equals("HDD")){
            HashMap <Integer, String> HDDs=new HashMap<>();
            HDDs.put(1, "256 Gb");
            HDDs.put(2, "512 Gb");
            HDDs.put(0, "1 Tb");
            HDDs.put(3, "2 Tb");
            HDDs.put(4, "128 Gb");
            System.out.println("Введите необходимый объем жесткого диска");
            System.out.println("0 - 1 Tb");
            System.out.println("1 - 256 Gb");
            System.out.println("2 - 512 Gb");
            System.out.println("3 - 2 Tb");
            System.out.println("4 - 128 Gb");
            
            int z =sc.nextInt();
            String zaprosRam=HDDs.get(z);
            if (filter.isEmpty()){
               for (Notebook not: shop){
                    if (not.hdd==zaprosRam){
                        filter.add(not);
                        System.out.println ("element "+not.hdd+" dobavlen");
                    }
                } 
            }else{
                Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                   Notebook nextNote = noteIterator.next();//получаем следующий элемент
                   if (!(nextNote.hdd.equals(zaprosRam))) {
                       noteIterator.remove();//удаляем ноут с ненужным ram
                   }
                }
            }
        }
    
    }
    /**
     * Процедура наполняет объектами Notebook списка filter, с 
     * введенными условиями <,> или = по параметрам obRam и obHdd.
     */
    public static void getLimit(ArrayList <Notebook> filter,ArrayList <Notebook> shop , Scanner sc){
        System.out.println("выбирите по какому параметру будем выбирать");
        System.out.println("1 - RAM");
        System.out.println("2 - HDD");
        String z =sc.nextLine();
        System.out.println("Введите  >, <, или =  ");
        String znak=sc.nextLine();
        System.out.println("Введите  числовое значение в Gb");
        int limit = sc.nextInt();
        
        if (z.equals("1")){
            if (filter.isEmpty()){
               for (Notebook not: shop){
                   if (znak.equals("<")){
                        if (not.obRam<limit){
                            filter.add(not);
                            
                        }
                   } else if (znak.equals(">")){
                           if (not.obRam>limit){
                                filter.add(not);
                                
                           }
                   }else if (znak.equals("=")){
                       if (not.obRam==limit){
                            filter.add(not);
                            
                       }
                   }
                } 
            }else{
                if (znak.equals("<")){
                    Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                    while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                       Notebook nextNote = noteIterator.next();//получаем следующий элемент
                       if (!(nextNote.obRam<limit)) {
                           noteIterator.remove();//удаляем ноут с ненужным ram
                       }
                    }
                } else if (znak.equals(">")){
                     Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                    while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                       Notebook nextNote = noteIterator.next();//получаем следующий элемент
                       if (!(nextNote.obRam>limit)){
                           noteIterator.remove();//удаляем ноут с ненужным ram
                       }
                    }
                }else if (znak.equals("=")){
                     Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                    while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                       Notebook nextNote = noteIterator.next();//получаем следующий элемент
                       if (!(nextNote.obRam==limit)) {
                           noteIterator.remove();//удаляем ноут с ненужным ram
                       }
                    }
                }
            }
            
        }else if (z.equals("2")){
            if (filter.isEmpty()){
               for (Notebook not: shop){
                   if (znak.equals("<")){
                        if (not.obHdd<limit){
                            filter.add(not);
                            
                        }
                   } else if (znak.equals(">")){
                           if (not.obHdd>limit){
                                filter.add(not);
                                
                           }
                   }else if (znak.equals("=")){
                       if (not.obHdd==limit){
                            filter.add(not);
                            
                       }
                   }
                } 
            }else{
                if (znak.equals("<")){
                    Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                    while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                       Notebook nextNote = noteIterator.next();//получаем следующий элемент
                       if (!(nextNote.obHdd<limit)) {
                           noteIterator.remove();//удаляем ноут с ненужным ram
                       }
                    }
                } else if (znak.equals(">")){
                     Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                    while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                       Notebook nextNote = noteIterator.next();//получаем следующий элемент
                       if (!(nextNote.obHdd>limit)){
                           noteIterator.remove();//удаляем ноут с ненужным ram
                       }
                    }
                }else if (znak.equals("=")){
                     Iterator<Notebook> noteIterator = filter.iterator();//создаем итератор
                    while(noteIterator.hasNext()) {//до тех пор, пока в списке есть элементы
                       Notebook nextNote = noteIterator.next();//получаем следующий элемент
                       if (!(nextNote.obHdd==limit)) {
                           noteIterator.remove();//удаляем ноут с ненужным ram
                       }
                    }
                }
            }
            
        }else{
            System.out.println("Введен неправильный параметр");
        }
    }
}