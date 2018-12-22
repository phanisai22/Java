package Polymorphism;

class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String plot() {
        return "No plot here .";
    }

}

class Inception extends Movie {
    public Inception() {
        super("Inception");
    }

    @Override
    public String plot() {
        return "The group of people tries to incept ideas into minds through dreams .";
    }
}

class Interstellar extends Movie {
    public Interstellar() {
        super("Interstellar");
    }

    @Override
    public String plot() {
        return "Exploration of space .";
    }

}

class ShutterIsland extends Movie {
    public ShutterIsland() {
        super("ShutterIsland");
    }

    @Override
    public String plot() {
        return "The person suffers with a disorder .";
    }
}

class Seven extends Movie {
    public Seven() {
        super("Seven");
    }

    @Override
    public String plot() {
        return "2 police men tries to catch a psyco .";
    }
}

class LoadOfRings extends Movie {
    public LoadOfRings() {
        super("LoadOfRings");
    }

    // No plot here .
}

class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie# " + (i + 1) + " : " + movie.getName() + "\nplot# " + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie() {
        int randomNumber = (int) ((Math.random() * 5) + 1);
        System.out.println("Random number generated is " + randomNumber);
        switch (randomNumber) {
        case 1:
            return new Inception();
        case 2:
            return new Interstellar();
        case 3:
            return new ShutterIsland();
        case 4:
            return new Seven();
        case 5:
            return new LoadOfRings();
        }
        return null;
    }
}