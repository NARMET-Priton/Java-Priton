package dati;

import business.Elemento;

public class ElementoList {

    private Elemento temp = new Elemento(null, null);
    private Elemento head = new Elemento(null, null);

    public void addToList(Elemento element) {
        if (head.getNext() == null) {
            head.setNext(element);
            temp = element;
        } else {
            temp.setNext(element);
            temp = element;
        }
    }

    public String outputList() {
        String list = "";
        Elemento temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            list += temp.toString();
        }
        return list;
    }

}
