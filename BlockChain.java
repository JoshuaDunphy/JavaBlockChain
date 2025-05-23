import java.util.ArrayList;
import javax.swing.SwingUtilities;


public class BlockChain {

        public static ArrayList<Block> blockchain = new ArrayList<Block>();
        public static int difficulty = 5;

        public static void main(String[] args) {
            
              SwingUtilities.invokeLater(() -> new Gui());


            // add our blocks to the blockchain ArrayList:
            blockchain.add(new Block("The genesis block.", "0"));
            System.out.println("Trying to Mine the genesis block... ");
            blockchain.get(0).mineBlock(difficulty);

            blockchain.add(new Block("The second block", blockchain.get(blockchain.size() - 1).hash));
            System.out.println("Trying to Mine the second block... ");
            blockchain.get(1).mineBlock(difficulty);

            blockchain.add(new Block("Hey im the second block", blockchain.get(blockchain.size() - 1).hash));
            System.out.println("Trying to Mine block 3... ");
            blockchain.get(2).mineBlock(difficulty);

            System.out.println("\nBlockchain is Valid: " + isChainValid());

            System.out.println("\nThe block chain: ");
        
        }

        public static Boolean isChainValid() {
            Block currentBlock;
            Block previousBlock;
            String hashTarget = new String(new char[difficulty]).replace('\0', '0');

            // loop through blockchain to check hashes:
            for (int i = 1; i < blockchain.size(); i++) {
                currentBlock = blockchain.get(i);
                previousBlock = blockchain.get(i - 1);
                // compare registered hash and calculated hash:
                if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                    System.out.println("Current Hashes not equal");
                    return false;
                }
                // compare previous hash and registered previous hash
                if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                    System.out.println("Previous Hashes not equal");
                    return false;
                }
                // check if hash is solved
                if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                    System.out.println("This block hasn't been mined");
                    return false;
                }
            }
            return true;
        }
    }

