public class MyList<E> implements SimpleList<E> {
    private Node<E> head;
    private int size = 0;

    public MyList() {
        head = null;
    }
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        if(size ==0) 
        	return true;
        else 
        	return false;
    }

    public void add(E element) {
        Node<E> aNode = new Node<E>(element);
        if(head==null) {
            this.head = aNode;
            size++;
        } else {
            Node<E> tmpNode = head;
            while(tmpNode.next != null) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = aNode;
            size++;
        }
    }

    public void add(int index,E element) {
        Node<E> aNode = new Node<E>(element);
        if(index==0) {
            aNode.next = this.head;
            this.head = aNode;
            size++;
        } else if (index>0) {
            Node<E> tmpNode = head;
            for(int i=0;i<index-1;i++) {
                tmpNode = tmpNode.next;
            }
            Node<E> tmp2Node = tmpNode.next;
            tmpNode.next = aNode;
            aNode.next = tmp2Node;
            size++;
            
        }
        
    }
    
    public E remove(int index) {
        if(index==0) {
            if(head!=null) {
                Node<E> result = head;
                head = null;
                size--;
                return result.data;
            }
        } else if (index>0) {
            Node<E> tmpNode = head;
            Node<E> result;
            for(int i=0;i<index-1;i++){
                tmpNode = tmpNode.next;
            }
            result = tmpNode.next;
            tmpNode.next = null;
            tmpNode.next = result.next;
            size--;
            return result.data;
        }
        return null;
    }
    
    public E remove() {
        if(head==null) {throw new IndexOutOfBoundsException();}
        else {
            Node<E> tmpNode = head;
            Node<E> result;
            while(tmpNode.next != null) {
                tmpNode = tmpNode.next;
            }
            result = tmpNode;
            tmpNode = null;
            size--;
            return result.data;
           
        }
    }
    public E get(int index) {
        if (index==0) {
            return head.data;
        } else if(index > 0) {
            Node<E> tmpNode = head;
            for(int i=0;i<index;i++) {
                tmpNode = tmpNode.next;
            }
            return tmpNode.data;
        }
        return null;
    }

}