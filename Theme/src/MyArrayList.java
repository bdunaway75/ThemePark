import java.util.Arrays;
public class MyArrayList
{
    private int[] data;
    private int size; //How many elements are in the array

    public MyArrayList()
    {
        size = 0; //No need to use this.size/data in any method since we are not reusing name in parameters.
        data = new int[3];
    }

    public MyArrayList(int[] arr)
    {
        data = arr;
        size = arr.length;
    }

    public void setData(int[] data) { //Added this for testing convinces
        this.data = data;
        size = data.length;
    }

    public int[] getData() {
        return data;
    }


    public void add(int n)
    /*Write up does not state whether we should worry about gaps in array for the method add*/
    {
        if(data.length == size) // If the array is already full
        {
            data = Arrays.copyOf(data, data.length + 1); //Adding another index to array
            data[data.length - 1] = n; //Placing N at that index
            size++;
        }

        else
        {
            data[data.length - 1] = n; //If array is not full, add N to the end of array
            size++;
        }
    }

    public boolean remove(int n)
    {
        if(n > size) //If the index is larger than the length of array
        {
            return false;
        }

        for(int i = n + 1; i < data.length; i++)
        {
            data[i -1] = data[i]; //Moving the element to the end of array
        }
        data = Arrays.copyOf(data, data.length-1); //New array with correct length and size
        data = Arrays.copyOf(data, data.length+1);
        size = size - 1;
        return true;
    }

    public String toString()
    {
        return Arrays.toString(this.data);
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0; //Returns true if size is 0, true otherwise
    }

    public int indexOf(int n)
    {
        int i;
        for(i = 0; i < data.length; i++) //Looping through each index
        {
            if(data[i] == n)
            {
                return i; //Returning i if elements are equal
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {

        int[] ar = {1,2,3,4,5,6};

        MyArrayList list = new MyArrayList(ar);
        list.remove(2);
        list.add(7);
        System.out.println(list.toString());


    }

}
