import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
	int quantity;
	int profit;
}
class ProfitComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		return item2.profit - item1.profit;
	}
	
}
public class MaxProfit {

	private static int maxpProfit(List<Item> items, int w) {
		int maxprofit = 0;
		Collections.sort(items, new ProfitComparator());
		for(Item item: items) {
			if(item.quantity <= w) {
				w = w - item.quantity;
				maxprofit += (item.quantity * item.profit);
			} else {
				maxprofit += (w * item.profit);
				break;
			}
		}
		return maxprofit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
