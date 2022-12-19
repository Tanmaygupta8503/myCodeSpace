import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		int q = Integer.parseInt(br.readLine());
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());
			choice = Integer.parseInt(st.nextToken());
			switch (choice) {
			case 1:
				input = Integer.parseInt(st.nextToken());
				bst.insert(input);
				break;
			case 2:
				input = Integer.parseInt(st.nextToken());
				bst.remove(input);
				break;
			case 3:
				input = Integer.parseInt(st.nextToken());
				System.out.println(bst.search(input));
				break;
			default:
				bst.printTree();
				break;
			}

		}
	}
}