import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private String name;
    private List<Token> tokenList;
    private Board board;

    public Player(String name) {
        this.name = name;
        this.tokenList = new ArrayList<>();
        this.tokenList = Collections.synchronizedList(tokenList);
    }

    public Player(String name, Board board) {
        this(name);
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public synchronized Token pickToken() {
        if (!board.tokenList.isEmpty()) {
            Token tmp = board.tokenList.get(0);
            board.tokenList.remove(0);
            return tmp;
        }
        return null;
    }

    @Override
    public synchronized void run() {
        Token newToken = pickToken();
        Random random=new Random();
        while (newToken != null) {
            System.out.println(this.name + " a extras : " + newToken.getValue());
            this.tokenList.add(newToken);
            newToken = pickToken();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}