package ritwik.codes.dataStructures.list;

public interface List<T> {

	boolean isEmpty();

	int getSize();

	void insert(T data);

	void insert(T data, int position);

	void delete();

	void delete(int position);

	T get(int position);

	void reverse();

}
