/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package interfaceplayingcards;

/**
 *
 * Copied from http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/java/IandI/examples/defaultmethods/PlayingCard.java
 * but renamed from PlayingCard to StandardCard, because it isn't general enough
 * to be called PlayingCard.
 */
public class StandardCard implements Card {
       
    protected final Card.Rank rank;
    protected final Card.Suit suit;
 
    public StandardCard(Card.Rank rank, Card.Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
     
    @Override
    public Card.Suit getSuit() {
        return suit;
    }
 
    @Override
    public Card.Rank getRank() {
        return rank;
    }
     
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            return ((Card)obj).getRank() == this.rank &&
                ((Card)obj).getSuit() == this.suit;
        } else {
            return false;
        }
    }
     
 
    @Override
    public int hashCode() {
        return ((suit.value()-1)*13)+rank.value();
    }
 
    @Override
    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }
 
    @Override
    public String toString() {
        return this.rank.text() + " of " + this.suit.text();
    }
 
    public static void main(String... args) {
        StandardCard aCard;
        aCard = new StandardCard(Rank.ACE, Suit.DIAMONDS);
        System.out.println("Suit: " + aCard.getSuit().toString()
            + ", Rank: " + aCard.getRank().toString());
        aCard = new StandardCard(Rank.KING, Suit.SPADES);
        System.out.println("Suit: " + aCard.getSuit().toString()
            + ", Rank: " + aCard.getRank().toString());
    }
}
