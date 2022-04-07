package app;

import java.util.Collection;
import java.util.Iterator;

/**
 * Generic linked list, that can store elements in a container
 *
 * @author jprie
 *
 */
public class GenericLinkedList<E> implements Iterable<E> {

    class Element  {

        public Element(E content, Element nextElement) {

            this.content = content;
            this.nextElement = nextElement;
        }

        private E content;
        private Element nextElement;

        @Override
        public String toString() {

            return content.toString();
        }
    }

    // Single-Ended Queue, speichert nur Referenz auf das 1. Element
    private Element firstElement;

    public GenericLinkedList(E[] values) {

        Element currentElement = null;

        // 5, 1, 2
        for (int i = 0; i < values.length; i++) {

            // only first step. 0 elemente
            if (firstElement == null) {
                firstElement = new Element(values[i], null);
                currentElement = firstElement;

            }
            else  {
                Element newElement  = new Element(values[i], null);
                currentElement.nextElement = newElement;
                currentElement = currentElement.nextElement;
            }

        }

    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append('[');

        Element currentElement = firstElement;

        while (currentElement != null) {

            builder.append(currentElement + " -> ");
            currentElement = currentElement.nextElement;
        }
        builder.append( "]");

        return builder.toString();
    }

    public void add(E content) {

        Element currentElement;
        if (firstElement == null) {
            firstElement = new Element(content, null);
        } else {

            currentElement = firstElement;

            while(currentElement.nextElement != null) {

                currentElement = currentElement.nextElement;
            }

            currentElement.nextElement = new Element(content, null);

        }

    }

    // @Herr Kaps: Das ist der Iterator
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            // Speichert beginnend beim ersten Element, das nächste Element
            Element nextElement = firstElement;
            @Override
            public boolean hasNext() {
                return nextElement != null;
            }

            @Override
            public E next() {
                E e = nextElement.content;
                nextElement = nextElement.nextElement;
                return e;
            }
        };
    }

}

