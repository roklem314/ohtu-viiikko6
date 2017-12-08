package statistics.matcher;

import java.util.ArrayList;
import statistics.Player;

public class QueryBuilder {

    public Matcher matcher;
    public Matcher savedMatcher;

    public QueryBuilder() {
        this.matcher = new Matcher() {
            @Override
            public boolean matches(Player p) {

                return true;
            }
        };
    }

    public QueryBuilder playsIn(String teamName) {

        //  Matcher playsIn = new PlaysIn(teamName);
        // vanha matcher
        // luo uusi missä vanha and playsIn
        Matcher uusi = new And(this.matcher, new PlaysIn(teamName));
        this.matcher = uusi;

        return this;
    }

    public Matcher build() {
        // ota talteen matcher
        // "resetoi" this.matcher 
        // palauta talletettu
        savedMatcher = this.matcher;
        this.matcher = new Matcher() {
            @Override
            public boolean matches(Player p) {
                return true;
            }
        };

        return savedMatcher;
    }

    public QueryBuilder hasAtLeast(int i, String goals) {
        //   Matcher hasAtLeast = new HasAtLeast(i, goals);
        this.matcher = new And(this.matcher, new HasAtLeast(i, goals));

        return this;
    }

    public QueryBuilder hasFewerThan(int i, String assists) {
        //Matcher hasFewerThan = new HasFewerThan(i, assists);
        this.matcher = new And(this.matcher, new HasFewerThan(i, assists));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
      // Matcher or = new Or(m1, m2);
        this.matcher = new Or(m1, m2);
        return this;
    }

}
