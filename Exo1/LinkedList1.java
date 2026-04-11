public class LinkedList1 {

    @SuppressWarnings("unused")
    private static class Node {
        String value;
        Node next;
    }

    // Pointeur vers le premier élément de la liste. Si la liste est vide, head vaut
    // null
    private Node head;

    public boolean find(String obj) {
        // VOTRE CODE VIENT ICI

        // Parcourir la liste jusqu'à trouver l'élément
        Node current = head;
        while (current != null) {
            if (current.value.equalsIgnoreCase(obj)) {
                return true;
            }
            current = current.next;
        }
        return false; // L'élément n'a pas été trouvé
    } // end of find()

    public boolean remove(String obj) {
        if (head == null) {
            // VOTRE PREMIER MORCEAU DU CODE VIENT ICI
            return false;
        }
        // VOTRE DEUXIEME MORCEAU DU CODE VIENT ICI
        // Si l'élément à supprimer est le premier de la liste
        if (head.value.equalsIgnoreCase(obj)) {
            head = head.next;
            return true;
        }
        // Parcourir la liste pour trouver l'élément à supprimer
        Node current = head;
        while (current.next != null) {
            if (current.next.value.equalsIgnoreCase(obj)) {
                current.next = current.next.next; // Relier les noeuds
                return true;
            }
            current = current.next;
        }
        return false; // L'élément n'a pas été trouvé
    } // end of remove()

    public void add(String obj) {
        // Créer un nouveau noeud avec la valeur en miniscule
        Node newNode = new Node();
        newNode.value = obj.toLowerCase();

        if (head == null) {
            // VOTRE PREMIER MORCEAU DU CODE VIENT ICI

            // Liste vide, le nouveau noeud devient le head
            head = newNode;
            return;
        }
        // VOTRE DEUXIEME MORCEAU DU CODE VIENT ICI

        // Le nouveau noeud va avant le premier noeud actuel
        if (newNode.value.compareTo(head.value) <= 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Trouver la position d'insertion du nouveau noeud
        Node current = head;
        while (current.next != null && current.next.value.compareTo(newNode.value) <= 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    } // end of add()

    public String[] getList() {
        String[] elements;

        // VOTRE PREMIER MORCEAU DU CODE VIENT ICI

        // Compteur, compter le nombre d'éléments dans la liste
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // VOTRE DEUXIEME MORCEAU DU CODE VIENT ICI

        // Remplir le tableau avec les éléments de la liste
        elements = new String[count];
        current = head;
        int i = 0;
        while (current != null) {
            elements[i] = current.value;
            current = current.next;
            i++;
        }
        return elements;
    } // end of getList()

} // end of LinkedList1 class
