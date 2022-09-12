import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{ //ICRUD를 구현
    ArrayList<Word> list;
    Scanner s;
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새로운 영단어 입력: ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.println("뜻 입력: ");
        String meaning = s.nextLine();
        return new Word(0, level, word, meaning);
    }
    public void addItem(){
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다.");

    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
    public void listAll(){
        if(list.size()==0){
            System.out.println("아직 등록된 단어가 없습니다.\n단어를 등록하여 주세요.\n  ");
        }
        else {
            System.out.println("-----------------------------------");
            for (int i = 0; i < list.size(); i++) {
                System.out.print((i + 1) + " ");
                System.out.println(list.get(i).toString());
            }
            System.out.println("-----------------------------------");
        }
    }
    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idlist = new ArrayList<>();
        int j=0;
        System.out.println("-----------------------------------");
        for(int i=0;i<list.size();i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((j+1)+" ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("-----------------------------------");
        return idlist;
    }

    public void exit() {
        System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
        System.exit(0);
    }

    public void updateItem() {
        System.out.println("=> 수정할 영단어 검색: ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택: ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻 입력: ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다. ");
    }

    public void deleteItem() {
    }
}
