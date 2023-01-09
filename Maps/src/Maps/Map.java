package Maps;

import java.util.ArrayList;
public class Map <K , V>{
	ArrayList<MapNode<K , V >> buckets;
	int size;
	int numBuckets;
	public Map() {
		numBuckets = 12;
		buckets = new ArrayList<>();
		for(int i = 0 ; i < 12 ;i ++)
		{
			buckets.add(null);
		}
	}
	private int getBucketsIndex(K key)
	{
		int hashCode = key.hashCode();
		return hashCode % numBuckets;
	}
	public int size()
	{
		return size;
	}
	public V getValue(K key) {
		int bucketIndex = getBucketsIndex(key);
		MapNode<K, V> head =buckets.get(bucketIndex);
		while(head != null)
		{
			if(head.key.equals(key))
			{
				return head.value;
			}
			head =head.next;
		}
		return null;
	}
	public V removeKey(K key)
	{
		int bucketIndex = getBucketsIndex(key);
		MapNode<K, V> head =buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while(head != null)
		{
			if(head.key.equals(key))
			{
				size -- ;
				if(prev == null)
				{
					buckets.set(bucketIndex, head.next);
				}
				else
				{
					prev.next = head.next;
				}
				return head.value;
			}
			prev =head;
			head =head.next;
		}
		return null;
	}
	public void insert(K key ,V value)
	{
		int bucketIndex = getBucketsIndex(key);
		MapNode<K, V> head =buckets.get(bucketIndex);
		size ++;
		while(head != null)
		{
			if(head.key.equals(key))
			{
				head.value = value;
			}
			head =head.next;
		}
		head =buckets.get(bucketIndex);
		MapNode<K, V> newElementsNode = new MapNode<K, V>(key, value);
		newElementsNode.next =head;
		buckets.set(bucketIndex, newElementsNode);
		double loadFactor = (1.0* size) / numBuckets;
		if(loadFactor > 0.7)
		{
			reHash();
		}
	}
	public double loadFactor()
	{
		return (1.0* size) / numBuckets;
	}
	private void reHash() {
		System.out.println("Rehashing : buckets " + numBuckets +"size " +size );
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		for(int i =0 ; i< 2 * numBuckets ; i++)
		{
			buckets.add(null);
		}
		size = 0;
		numBuckets *= 2;
		for(int  i = 0 ;i < temp.size();i ++ )
		{
			MapNode<K, V> head =temp.get(i);
			while(head != null)
			{
				K key =head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
		}
	}
}
