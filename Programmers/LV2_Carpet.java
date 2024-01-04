/*
Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ��������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.

Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.

Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
���� ������ �� brown�� 8 �̻� 5,000 ������ �ڿ����Դϴ�.
����� ������ �� yellow�� 1 �̻� 2,000,000 ������ �ڿ����Դϴ�.
ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.

����� ��
brown	yellow	return
10	    2	    [4, 3]
8	    1	    [3, 3]
24	    24	    [8, 6]
*/

import java.util.Arrays;
import java.io.IOException;

public class LV2_Carpet {
    public static void main(String[] args) {
        int totalTest = 3;
        int successTest = 0;
        int failTest = 0;

// 1�� �׽�Ʈ
        if (test(10, 2, 4, 3)) successTest += 1;
        else failTest += 1;

// 2�� �׽�Ʈ
        if (test(8, 1, 3, 3)) successTest += 1;
        else failTest += 1;

// 3�� �׽�Ʈ
        if (test(24, 24, 8, 6)) successTest += 1;
        else failTest += 1;

        System.out.println("�� 3�� �߿� " + successTest + "�� ���� / " + failTest + "�� ����");
    }

    private static boolean test(int inputBrown, int inputYellow, int width, int height) {
        int[] answer = {width, height};
        int[] predict = null;

        try {
            predict = remindCarpetInfo(inputBrown, inputYellow);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        if (Arrays.equals(predict, answer))  {
            return true;
        } else {
            System.out.printf("���� �׵θ� Ÿ���� %d���̰�, ����� Ÿ���� %d���� ��, ������ %d, %d������, �����δ� %d, %d����. \n"
            ,inputBrown, inputYellow, predict[0], predict[1], width, height);
            
            return false;
        }
    }

    private static int[] remindCarpetInfo(int brown, int yellow) throws IOException{
        int width;
        int height = 3;

        while (true) {
            width = (brown - 2*height + 4) / 2;

            if (width * height == (brown + yellow)) return new int[] {width, height};
            
            height++;
            if (width < height) throw new IOException("���� ã�� �� �����ϴ�. �Է°��� �ٽ� Ȯ�����ּ���.");
        }
    }
}
