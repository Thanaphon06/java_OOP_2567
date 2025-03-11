package week6_array;
import java.util.Random;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class ElectionVoteCount {
    public static void main(String[] args) {

        DecimalFormat deci = new DecimalFormat("#.##");
        final int People = 50000; // จำนวนประชากร
        int[] votes = new int[7]; // อาเรย์สำหรับเก็บคะแนน (0 - 6)
        
        String voteCount = "" ,
        underTail = "\n--------------------------------------\n";

        // สุ่มคะแนนระหว่าง 0 - 6 สำหรับประชากร 50,000 คน
        Random random = new Random();
        for (int i = 0; i < People; i++) {
            int vote = (int) (Math.random() * 7); // สุ่มค่าระหว่าง 0 ถึง 6
            votes[vote]++;
        }

        // คำนวณจำนวนผู้ใช้สิทธิ์
        int totalVotes = People - votes[0] - votes[6]; // นับจำนวนผู้ใช้สิทธิ์โดยลบคนที่งดออกสิทธิ์ (0) และบัตรเสีย (6)

        voteCount += "Vote Count :\n" + 
        "Total Population: " + People + "\n" +
        "Total Votes: " + totalVotes + "\n" +
        "Voter Turnout: " + deci.format(((double) totalVotes / People) * 100) + "%" + "\n"+
        "Invalid Votes (Card Lost): " + votes[6] + "\n" +
        "Abstained Votes: " + votes[0] + underTail;
        // แสดงผลคะแนน
        

        System.out.println("\nVote Count by Candidates:");
        for (int i = 1; i <= 4; i++) {
            voteCount += "Candidate " + i + ": " + votes[i] + " votes" + "\n";
        }

        voteCount += underTail + "Results\n" ;
        // แสดงผลคะแนนโดยการหาผู้ชนะ
     
        int[] candidatesVotes = {votes[1], votes[2], votes[3], votes[4]};
        String[] candidates = {"Candidate 1", "Candidate 2", "Candidate 3", "Candidate 4"};
        
        // Sort the candidates based on their votes in descending order
        for (int i = 0; i < candidatesVotes.length - 1; i++) {
            for (int j = i + 1; j < candidatesVotes.length; j++) {
                if (candidatesVotes[i] < candidatesVotes[j]) {
                    // Swap votes
                    int temp = candidatesVotes[i];
                    candidatesVotes[i] = candidatesVotes[j];
                    candidatesVotes[j] = temp;
                    // Swap candidate names
                    String tempName = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = tempName;
                }
            }
        }

        // แสดงผลลำดับผู้ชนะ
        voteCount += "Winner :\n";
        for (int i = 0; i < candidatesVotes.length; i++) {
            double percentage = ((double) candidatesVotes[i] / totalVotes) * 100;

            voteCount += candidates[i] + ": " + candidatesVotes[i] + " votes  " + deci.format(percentage) + "%" + "\n";
        }

        JOptionPane.showMessageDialog(null, voteCount, "Vote Count", 3);

    }
}
