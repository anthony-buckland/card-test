package za.co.aboutblank.consts;

 public interface HandCalculator {
     boolean isFourOfAKind(String[] cards);

     boolean isFullHouse(String[] cards);

     boolean isFlush(String[] cards);

     boolean isStraight(String[] cards);

     boolean isThreeOfAKind(String[] cards);

     boolean isTwoPair(String[] cards);

     boolean isOnePair(String[] cards);

     boolean isHighCard(String[] cards);
}
