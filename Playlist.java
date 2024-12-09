class Playlist {
    SongNode head;
    
    public void addSong(String title, String artist, int year, int minutes, int seconds, String genre) {
        SongNode newSong = new SongNode(title, artist, year, minutes, seconds, genre);
        if (head == null) {
            head = newSong;
        } else {
            SongNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
            newSong.prev = current;
        }
    }
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("===========================================================");
            System.out.println("||                      LOL Playlist                     ||");
            System.out.println("===========================================================");
            System.out.println("           There is no song in the playlist yet.");
            System.out.println("===========================================================");
        } else {
            System.out.println("===========================================================");
            System.out.println("||                      LOL Playlist                     ||");
            System.out.println("===========================================================");
            SongNode current = head;
            int index = 1;
            while (current != null) {
                System.out.println(index + " | " + current.title + " - " + current.artist + " (" + current.year + ")");
                System.out.printf("  %d:%02d %s\n", current.minutes, current.seconds, current.genre);
                System.out.println("===========================================================");
                current = current.next;
                index++;
            }
        }
    }
    public void sortPlaylistByDuration() {
        if (head == null || head.next == null) return;

        long startTime = System.nanoTime(); 

        for (SongNode i = head; i != null; i = i.next) {
            for (SongNode j = i.next; j != null; j = j.next) {
                if ((i.minutes > j.minutes) || (i.minutes == j.minutes && i.seconds > j.seconds)) {
                    swap(i, j);
                }
            }
        }

        long endTime = System.nanoTime(); 
        long duration = endTime - startTime;
        System.out.println("Waktu yang dibutuhkan untuk mengurutkan berdasarkan durasi: " + duration + " nanodetik");
    }

    public void sortPlaylistByYear() {
        if (head == null || head.next == null) return;

        long startTime = System.nanoTime(); 

        for (SongNode i = head; i != null; i = i.next) {
            for (SongNode j = i.next; j != null; j = j.next) {
                if (i.year > j.year) {
                    swap(i, j);
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Waktu yang dibutuhkan untuk mengurutkan berdasarkan tahun: " + duration + " nanodetik");
    }

    // Menukar data dua node
    private void swap(SongNode a, SongNode b) {
        String tempTitle = a.title;
        String tempArtist = a.artist;
        int tempYear = a.year;
        int tempMinutes = a.minutes;
        int tempSeconds = a.seconds;
        String tempGenre = a.genre;

        a.title = b.title;
        a.artist = b.artist;
        a.year = b.year;
        a.minutes = b.minutes;
        a.seconds = b.seconds;
        a.genre = b.genre;

        b.title = tempTitle;
        b.artist = tempArtist;
        b.year = tempYear;
        b.minutes = tempMinutes;
        b.seconds = tempSeconds;
        b.genre = tempGenre;
    }
    public void searchSongByTitle(String title) {
        long startTime = System.nanoTime(); 

        SongNode current = head;
        boolean found = false;
        int position = 1;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("Lagu ditemukan pada posisi " + position + ":");
                System.out.println(current.title + " - " + current.artist + " (" + current.year + ")");
                System.out.printf("%d:%02d %s\n", current.minutes, current.seconds, current.genre);
                found = true;
                break;
            }
            current = current.next;
            position++;
        }

        if (!found) {
            System.out.println("Lagu dengan judul \"" + title + "\" tidak ditemukan di playlist.");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Waktu yang dibutuhkan untuk pencarian lagu: " + duration + " nanodetik");
    }
}