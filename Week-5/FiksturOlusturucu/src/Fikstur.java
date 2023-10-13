import java.util.*;

public class Fikstur {
    private static ArrayList<String> teams = new ArrayList<>();

    // Takım isimleri eklenir
    static {
        teams.add("Fenerbahçe");
        teams.add("Galatasaray");
        teams.add("Beşiktaş");
        teams.add("Trabzonspor");
        teams.add("Giresunspor");
        teams.add("Adana Demir Spor");
        teams.add("Ankaragücü");
    }
    public static void generateRandomFixtures() {
        // Eğer takım sayısı tek ise "Bay" takımını ekle
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }
        int numTeams = teams.size();
        int totalRounds = numTeams - 1; // Toplam tur sayısı

        Random random = new Random();

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("Round " + round + ":");

            // Karşılaşmaları rastgele seç
            List<String> remainingTeams = new ArrayList<>(teams);
            Collections.shuffle(remainingTeams);

            for (int i = 0; i < numTeams / 2; i++) {
                String homeTeam = remainingTeams.get(i);
                String awayTeam = remainingTeams.get(numTeams - 1 - i);

                // Eğer maçı yapacak takım "Bay" ise bu turda maç yapılmayacak
                if (homeTeam.equals("Bay") || awayTeam.equals("Bay")) {
                    System.out.println(homeTeam + " vs " + awayTeam + " (Bay)");
                } else {
                    System.out.println(homeTeam + " vs " + awayTeam);
                }
            }
            System.out.println("--------------------------------------------------");
        }
    }
}
