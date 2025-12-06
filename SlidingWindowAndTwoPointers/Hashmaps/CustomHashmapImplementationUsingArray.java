package SlidingWindowAndTwoPointers.Hashmaps;


public class CustomHashmapImplementationUsingArray {

    Entity[] entities;
    public CustomHashmapImplementationUsingArray() {
        this.entities = new Entity[100];
    }

    public void put(String key , String value) {
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value);
    }

    public String get(String key) {
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)) {
            return entities[hash].value;
        }
        return null;
    }

    public void remove(String key) {
        int hash = Math.abs(key.hashCode() % entities.length);
        if (entities[hash] != null && entities[hash].key.equals(key)) {
            entities[hash] = null;
        }
    }


    private static class Entity {
         String key;
         String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}


class Main {
    public static void main(String[] args) {
        CustomHashmapImplementationUsingArray chi = new CustomHashmapImplementationUsingArray();
        chi.put("Aditya Bhatt" , "Boy");
        chi.put("Ishika Jindal" , "Girl");
        chi.put("Nitin Dogra" , "Boy");

        System.out.println(chi.get("Aditya Bhatt"));

    }
}