interface Playable {
    void play();
}
class Guitar implements Playable {
    public void play() {
        System.out.println("Strumming Guitar");
    }
}
class Piano implements Playable {
    public void play() {
        System.out.println("Playing Piano");
    }
    public static void main(String[] args) {
        Playable g = new Guitar();
        Playable p = new Piano();
        g.play();
        p.play();
    }
}
