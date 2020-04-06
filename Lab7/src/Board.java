import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private int tokens;
    List<Token> tokenList;

    public Board(int tokens) {
        this.tokens = tokens;
        this.tokenList = new ArrayList<>(tokens);
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void generateTokenList() {
        for (int i = 1; i <= tokens; ++i) {
            tokenList.add(new Token(i));
        }
        Collections.shuffle(tokenList);
        this.tokenList = Collections.synchronizedList(tokenList);
    }
}