/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubic;

public class Cubic {
    int cub[][][];
    int w_h;
    public Cubic(int a){     
        cub = new int[7][a+1][a+1];
        w_h = a;
        for(int i=0; i<a; i++){
            cub[i][0][0]=a;
            cub[0][i][0]=a;
            cub[0][0][i]=a;
        }
    }
    public int getW_h(){
        return w_h;
    }
    public void setCub(int i, int j, int k, int el){
        cub[i][j][k]=el;
    }
    public int getCub(int i, int j, int k){
        return cub[i][j][k];
    }
    //Action
    public static boolean check(Cubic cub) {
        System.out.println("Check");
        Watch(cub);
        for (int i = 1; i < 6; i++)
            for (int j = 1; j < cub.getW_h(); j++)
                for (int k = 1; k < cub.getW_h(); k++)
                    if (cub.getCub(i, j, k)!=cub.getCub(i, 1, 1)) return false;
        return true;
    }
    public static void Watch(Cubic cub) {
        for(int i=0;i<cub.getW_h();i++)
            for(int j=0; j<cub.getW_h(); j++){
                System.out.print("   ");
                System.out.print(cub.getCub(6,i,j));
                System.out.print(cub.getCub(6,i,j));
                System.out.println(cub.getCub(6,i,j));
            }

        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(4,0,i));
        }
        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(1,0,i));
        }
        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(2,0,i));
        }

        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(4,1,i));
        }
        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(1,1,i));
        }
        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(2,1,i));
        }

        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(4,2,i));
        }
        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(1,2,i));
        }
        for(int i=0;i<cub.getW_h();i++){
            System.out.print(cub.getCub(2,2,i));
        }

        for(int i=0;i<cub.getW_h();i++)
            for(int j=0; j<cub.getW_h(); j++){
                System.out.print("   ");
                System.out.print(cub.getCub(5,i,j));
                System.out.print(cub.getCub(5,i,j));
                System.out.println(cub.getCub(5,i,j));
            }

        for(int i=0;i<cub.getW_h();i++)
            for(int j=0; j<cub.getW_h(); j++){
                System.out.print("   ");
                System.out.print(cub.getCub(3,i,j));
                System.out.print(cub.getCub(3,i,j));
                System.out.println(cub.getCub(3,i,j));
            }
    }
    //support
    public static int[][][] rank_gorizontal(int[][][] cub, int a, int b, int r){
        for(int i=1; i <= cub[0][0][0]; i++)
            cub[a][r][i] = cub[b][r][i];
        return cub;
    }
    public static int[]     buff_gorizontal_input(int[][][] cub, int g, int r){
        int[] b = null;
        for (int i = 1; i <= cub[0][0][0]; i++)
            b[i] = cub [g][r][i];
        return b;
    }
    public static int[][][] buff_gorizontal_output(int[][][] cub, int[] b, int g, int r){
        for (int i = 1; i <= cub[0][0][0]; i++)
            cub [g][r][i] = b[i];
        return cub;
    }
    public static int[][][] rank_vertical(int[][][] cub, int a, int b, int s){
        for(int i=1; i <= cub[0][0][0]; i++)
            cub[a][i][s] = cub[b][i][s];
        return cub;
    }
    public static int[]     buff_vertical_input(int[][][] cub, int g, int s){
        int[] b = null;
        for (int i = 1; i <= cub[0][0][0]; i++)
            b[i] = cub [g][i][s];
        return b;
    }
    public static int[][][] buff_vertical_output(int[][][] cub, int[] b, int g, int s){
        for (int i = 1; i <= cub[0][0][0]; i++)
            cub [g][i][s] = b[i];
        return cub;
    }
    public static int[][][] Uhr_protiv  (int[][][] cub, int g){
        int[] b = null;
        b = buff_gorizontal_input(cub, g, 1);
        cub[g][1][2] = cub[g][2][3];
        cub[g][1][3] = cub[g][3][3];
        cub[g][2][3] = cub[g][3][2];
        cub[g][3][3] = cub[g][3][1];
        cub[g][3][2] = cub[g][2][1];
        for (int i = cub[0][0][0]; i <= 1; i--)
            cub [g][i][1] = b[i];
        return cub;
    }
    public static int[][][] Uhr_po      (int[][][] cub, int g){
        int[] b = null;
        b = buff_gorizontal_input(cub, g, 1);
        cub[g][1][2] = cub[g][2][1];
        cub[g][1][1] = cub[g][3][1];
        cub[g][2][1] = cub[g][3][2];
        cub[g][3][1] = cub[g][3][3];
        cub[g][3][2] = cub[g][2][3];
        for (int i = cub[0][0][0]; i <= 1; i--)
            cub [g][i][1] = b[i];
        return cub;
    }
    //gorizontal
    public static int[][][] rotate_Vr(int[][][] cub) {
        int[] b = null;
        b = buff_gorizontal_input(cub, 1, 1);
        cub = rank_gorizontal(cub, 1, 4, 1);
        cub = rank_gorizontal(cub, 4, 3, 1);
        cub = rank_gorizontal(cub, 3, 2, 1);
        cub = buff_gorizontal_output(cub, b, 2, 1);
        cub = Uhr_protiv(cub, 6);
        return cub;
    }
    public static int[][][] rotate_Vl(int[][][] cub) {
        int[] b = null;
        b = buff_gorizontal_input(cub, 1, 1);
        cub = rank_gorizontal(cub, 1, 2, 1);
        cub = rank_gorizontal(cub, 2, 3, 1);
        cub = rank_gorizontal(cub, 3, 4, 1);
        cub = buff_gorizontal_output(cub, b, 4, 1);
        cub = Uhr_po(cub, 6);
        return cub;
    }
    public static int[][][] rotate_Nr(int[][][] cub) {
        int[] b = null;
        b = buff_gorizontal_input(cub, 1, 3);
        cub = rank_gorizontal(cub, 1, 4, 3);
        cub = rank_gorizontal(cub, 4, 3, 3);
        cub = rank_gorizontal(cub, 3, 2, 3);
        cub = buff_gorizontal_output(cub, b, 2, 3);
        cub = Uhr_po(cub, 5);
        return cub;
    }
    public static int[][][] rotate_Nl(int[][][] cub) {
        int[] b = null;
        b = buff_gorizontal_input(cub, 1, 3);
        cub = rank_gorizontal(cub, 1, 2, 3);
        cub = rank_gorizontal(cub, 2, 3, 3);
        cub = rank_gorizontal(cub, 3, 4, 3);
        cub = buff_gorizontal_output(cub, b, 4, 3);
        cub = Uhr_protiv(cub, 5);
        return cub;
    }
    public static int[][][] rotate_Zr(int[][][] cub) {
        int[] b = null;
        b = buff_gorizontal_input(cub, 1, 2);
        cub = rank_gorizontal(cub, 1, 4, 2);
        cub = rank_gorizontal(cub, 4, 3, 2);
        cub = rank_gorizontal(cub, 3, 2, 2);
        cub = buff_gorizontal_output(cub, b, 2, 2);
        return cub;
    }
    public static int[][][] rotate_Zl(int[][][] cub) {
        int[] b = null;
        b = buff_gorizontal_input(cub, 1, 2);
        cub = rank_gorizontal(cub, 1, 2, 2);
        cub = rank_gorizontal(cub, 2, 3, 2);
        cub = rank_gorizontal(cub, 3, 4, 2);
        cub = buff_gorizontal_output(cub, b, 4, 2);
        return cub;
    }
    public static int[][][] gran_left(int[][][] cub) {
        cub = rotate_Vl(cub);
        cub = rotate_Zl(cub);
        cub = rotate_Nl(cub);
        return cub;
    }
    public static int[][][] gran_right(int[][][] cub) {
        cub = rotate_Vr(cub);
        cub = rotate_Zr(cub);
        cub = rotate_Nr(cub);
        return cub;
    }
    //vertical
    public static int[][][] left_up(int[][][]) {
        int[] b = null;
        b = buff_vertical_input(cub, 1, 1);
        cub = rank_vertical(cub, 1, 5, 1);
        cub = rank_vertical(cub, 5, 3, 1);
        cub = rank_vertical(cub, 3, 6, 1);
        cub = buff_vertical_output(cub, b, 6, 1);
        cub = Uhr_protiv(cub, 4);
        return cub;
    }
    public static int[][][] left_down(int[][][] cub) {
        int[] b = null;
        b = buff_vertical_input(cub, 1, 1);
        cub = rank_vertical(cub, 1, 6, 1);
        cub = rank_vertical(cub, 6, 3, 1);
        cub = rank_vertical(cub, 3, 5, 1);
        cub = buff_vertical_output(cub, b, 5, 1);
        cub = Uhr_po(cub, 4);
        return cub;
    }
    public static int[][][] right_up(int[][][] cub) {
        int[] b = null;
        b = buff_vertical_input(cub, 1, 3);
        cub = rank_vertical(cub, 1, 5, 3);
        cub = rank_vertical(cub, 5, 3, 3);
        cub = rank_vertical(cub, 3, 6, 3);
        cub = buff_vertical_output(cub, b, 6, 3);
        cub = Uhr_po(cub, 2);
        return cub;
    }
    public static int[][][] right_down(int[][][] cub) {
        int[] b = null;
        b = buff_vertical_input(cub, 1, 3);
        cub = rank_vertical(cub, 1, 6, 3);
        cub = rank_vertical(cub, 6, 3, 3);
        cub = rank_vertical(cub, 3, 5, 3);
        cub = buff_vertical_output(cub, b, 5, 3);
        cub = Uhr_protiv(cub, 2);
        return cub;
    }
    public static int[][][] midle_up(int[][][] cub) {
        int[] b = null;
        b = buff_vertical_input(cub, 1, 2);
        cub = rank_vertical(cub, 1, 5, 2);
        cub = rank_vertical(cub, 5, 3, 2);
        cub = rank_vertical(cub, 3, 6, 2);
        cub = buff_vertical_output(cub, b, 6, 2);
        return cub;
    }
    public static int[][][] midle_down(int[][][] cub) {
        int[] b = null;
        b = buff_vertical_input(cub, 1, 2);
        cub = rank_vertical(cub, 1, 6, 2);
        cub = rank_vertical(cub, 6, 3, 2);
        cub = rank_vertical(cub, 3, 5, 2);
        cub = buff_vertical_output(cub, b, 5, 2);
        return cub;
    }
    public static int[][][] gran_up(int[][][] cub) {
        cub = left_up(cub);
        cub = midle_up(cub);
        cub = right_up(cub);
        return cub;
    }
    public static int[][][] gran_down(int[][][] cub) {
        cub = left_down(cub);
        cub = midle_down(cub);
        cub = right_down(cub);
        return cub;
    }
}
