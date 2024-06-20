package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_6580 {
    static boolean[][] photoPixels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Read the size of the quadtree
        String[] pixelInfo = br.readLine().split(" ");
        for (int i = 0; i < 2; i++) br.readLine(); // Skip the next two lines
        int pixelSize = Integer.parseInt(pixelInfo[2]);
        int convertedPixel = pixelSize / 8;
        photoPixels = new boolean[pixelSize][pixelSize];

        // Read the pixel data and convert it to boolean array
        for (int i = 0; i < pixelSize; i++) {
            pixelInfo = br.readLine().split(",");
            for (int j = 0; j < convertedPixel; j++) {
                makePixels(convertHexToBinary(pixelInfo[j]), i, j * 8);
            }
        }

        // Encode the pixel data to quadtree format
        sb.append(pixelSize).append("\n")
                .append(encodeToQuadtree(pixelSize, 0, 0)).append("\n");

        System.out.print(sb);
        br.close();
    }

    // Convert hex string to binary string
    static String convertHexToBinary(String hexString) {
        int hexNum = Integer.parseInt(hexString.substring(2), 16); // Skip "0x" prefix
        String binary = Integer.toBinaryString(hexNum);
        StringBuilder sb = new StringBuilder("0".repeat(8 - binary.length())).append(binary);
        return sb.toString();
    }

    // Populate the photoPixels array based on the binary string
    static void makePixels(String binaryString, int row, int col) {
        for (char b : binaryString.toCharArray()) {
            photoPixels[row][col++] = b == '1';
        }
    }

    // Encode the photoPixels array to quadtree format
    static String encodeToQuadtree(int size, int row, int col) {
        if (isUniform(size, row, col)) return photoPixels[row][col] ? "B" : "W";

        StringBuilder sb = new StringBuilder();
        int half = size / 2;
        sb.append("Q")
                .append(encodeToQuadtree(half, row, col))
                .append(encodeToQuadtree(half, row, col + half))
                .append(encodeToQuadtree(half, row + half, col))
                .append(encodeToQuadtree(half, row + half, col + half));

        return sb.toString();
    }

    // Check if all pixels in the given area are the same
    static boolean isUniform(int size, int row, int col) {
        boolean standardPixel = photoPixels[row][col];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (photoPixels[row + i][col + j] != standardPixel) return false;
            }
        }
        return true;
    }
}