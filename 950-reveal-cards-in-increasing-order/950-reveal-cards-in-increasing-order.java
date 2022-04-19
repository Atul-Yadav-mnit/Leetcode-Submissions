class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int ans[] = new int[deck.length];
        Arrays.sort(deck);
        int x = 0,i=0;
        while(x<deck.length)
        {
            ans[i] = deck[x++];
            if(x==deck.length)
            {
                break;
            }
            while(true)
            {
                i = (i+1)%deck.length;
                if(ans[i] == 0)
                {
                    break;
                }
            }
             while(true)
            {
                i = (i+1)%deck.length;
                if(ans[i] == 0)
                {
                    break;
                }
            }
        }
        return ans;
    }
}