/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubic;

public class Cubic {
    static int cub[][][];
    static int w_h;
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
    public static boolean check() {
        System.out.println("Check");
        Watch();
        for (int i = 1; i < 6; i++)
            for (int j = 1; j < w_h; j++)
                for (int k = 1; k < w_h; k++)
                    if (cub[i][j][k]!=cub[i][1][1]) return false;
        return true;
    }
    public static void Watch() {
        for(int i=1;i<=w_h;i++){
            System.out.print("   ");
            for(int j=1; j<=w_h; j++){    
                System.out.print(cub[6][i][j]);     
            }
            System.out.println("");
        }
        
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[4][1][i]);
        }
        System.out.println("");
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[1][1][i]);
        }
        System.out.println("");
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[2][1][i]);
        }
        System.out.println("");
        
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[4][1][i]);
        }
        System.out.println("");
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[1][1][i]);
        }
        System.out.println("");
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[2][1][i]);
        }
        System.out.println("");
        
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[4][2][i]);
        }
        System.out.println("");
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[1][2][i]);
        }
        System.out.println("");
        for(int i=1;i<=w_h;i++){
            System.out.print(cub[2][2][i]);
        }
        System.out.println("");
        
        for(int i=1;i<=w_h;i++){
            System.out.print("   ");
            for(int j=1; j<=w_h; j++){
                System.out.print(cub[5][i][j]);
            }
            System.out.println("");
        }
        for(int i=1;i<=w_h;i++){
            System.out.print("   ");
            for(int j=1; j<=w_h; j++){
                System.out.print(cub[3][i][j]);
            }
            System.out.println("");
        }
    }
    //support
    public static void rank_gorizontal(int a, int b, int r){
        for(int i=1; i <= cub[0][0][0]; i++)
            cub[a][r][i] = cub[b][r][i];
    }
    public static int[]     buff_gorizontal_input(int g, int r){
        int[] b = null;
        for (int i = 1; i <= cub[0][0][0]; i++)
            b[i] = cub [g][r][i];
        return b;
    }
    public static void buff_gorizontal_output(int[] b, int g, int r){
        for (int i = 1; i <= cub[0][0][0]; i++)
            cub [g][r][i] = b[i];
    }
    public static void rank_vertical(int a, int b, int s){
        for(int i=1; i <= cub[0][0][0]; i++)
            cub[a][i][s] = cub[b][i][s];
    }
    public static int[]     buff_vertical_input(int g, int s){
        int[] b = null;
        for (int i = 1; i <= cub[0][0][0]; i++)
            b[i] = cub [g][i][s];
        return b;
    }
    public static void buff_vertical_output(int[] b, int g, int s){
        for (int i = 1; i <= cub[0][0][0]; i++)
            cub [g][i][s] = b[i];
    }
    public static void Uhr_protiv  (int g){
        int[] b = null;
        b = buff_gorizontal_input(g, 1);
        cub[g][1][2] = cub[g][2][3];
        cub[g][1][3] = cub[g][3][3];
        cub[g][2][3] = cub[g][3][2];
        cub[g][3][3] = cub[g][3][1];
        cub[g][3][2] = cub[g][2][1];
        for (int i = cub[0][0][0]; i <= 1; i--)
            cub [g][i][1] = b[i];
    }
    public static void Uhr_po      (int g){
        int[] b = null;
        b = buff_gorizontal_input(g, 1);
        cub[g][1][2] = cub[g][2][1];
        cub[g][1][1] = cub[g][3][1];
        cub[g][2][1] = cub[g][3][2];
        cub[g][3][1] = cub[g][3][3];
        cub[g][3][2] = cub[g][2][3];
        for (int i = cub[0][0][0]; i <= 1; i--)
            cub [g][i][1] = b[i];
    }
    //gorizontal
    public static void rotate_Vr() {
        int[] b = null;
        b = buff_gorizontal_input(1, 1);
        rank_gorizontal(1, 4, 1);
        rank_gorizontal(4, 3, 1);
        rank_gorizontal(3, 2, 1);
        buff_gorizontal_output(b, 2, 1);
        Uhr_protiv(6);
    }
    public static void rotate_Vl() {
        int[] b = null;
        b = buff_gorizontal_input(1, 1);
        rank_gorizontal(1, 2, 1);
        rank_gorizontal(2, 3, 1);
        rank_gorizontal(3, 4, 1);
        buff_gorizontal_output(b, 4, 1);
        Uhr_po(6);
    }
    public static void rotate_Nr() {
        int[] b = null;
        b = buff_gorizontal_input(1, 3);
        rank_gorizontal(1, 4, 3);
        rank_gorizontal(4, 3, 3);
        rank_gorizontal(3, 2, 3);
        buff_gorizontal_output(b, 2, 3);
        Uhr_po(5);
    }
    public static void rotate_Nl() {
        int[] b = null;
        b = buff_gorizontal_input(1, 3);
        rank_gorizontal(1, 2, 3);
        rank_gorizontal(2, 3, 3);
        rank_gorizontal(3, 4, 3);
        buff_gorizontal_output(b, 4, 3);
        Uhr_protiv(5);
    }
    public static void rotate_Zr() {
        int[] b = null;
        b = buff_gorizontal_input(1, 2);
        rank_gorizontal(1, 4, 2);
        rank_gorizontal(4, 3, 2);
        rank_gorizontal(3, 2, 2);
        buff_gorizontal_output(b, 2, 2);
    }
    public static void rotate_Zl() {
        int[] b = null;
        b = buff_gorizontal_input(1, 2);
        rank_gorizontal(1, 2, 2);
        rank_gorizontal(2, 3, 2);
        rank_gorizontal(3, 4, 2);
        buff_gorizontal_output(b, 4, 2);
    }
    public static void gran_left() {
        rotate_Vl();
        rotate_Zl();
        rotate_Nl();
    }
    public static void gran_right() {
        rotate_Vr();
        rotate_Zr();
        rotate_Nr();
    }
    //vertical
    public static void left_up() {
        int[] b = null;
        b = buff_vertical_input(1, 1);
        rank_vertical(1, 5, 1);
        rank_vertical(5, 3, 1);
        rank_vertical(3, 6, 1);
        buff_vertical_output(b, 6, 1);
        Uhr_protiv(4);
    }
    public static void left_down() {
        int[] b = null;
        b = buff_vertical_input(1, 1);
        rank_vertical(1, 6, 1);
        rank_vertical(6, 3, 1);
        rank_vertical(3, 5, 1);
        buff_vertical_output(b, 5, 1);
        Uhr_po(4);
    }
    public static void right_up() {
        int[] b = null;
        b = buff_vertical_input(1, 3);
        rank_vertical(1, 5, 3);
        rank_vertical(5, 3, 3);
        rank_vertical(3, 6, 3);
        buff_vertical_output(b, 6, 3);
        Uhr_po(2);
    }
    public static void right_down() {
        int[] b = null;
        b = buff_vertical_input(1, 3);
        rank_vertical(1, 6, 3);
        rank_vertical(6, 3, 3);
        rank_vertical(3, 5, 3);
        buff_vertical_output(b, 5, 3);
        Uhr_protiv(2);
    }
    public static void midle_up() {
        int[] b = null;
        b = buff_vertical_input(1, 2);
        rank_vertical(1, 5, 2);
        rank_vertical(5, 3, 2);
        rank_vertical(3, 6, 2);
        buff_vertical_output(b, 6, 2);
    }
    public static void midle_down() {
        int[] b = null;
        b = buff_vertical_input(1, 2);
        rank_vertical(1, 6, 2);
        rank_vertical(6, 3, 2);
        rank_vertical(3, 5, 2);
        buff_vertical_output(b, 5, 2);
    }
    public static void gran_up() {
        left_up();
        midle_up();
        right_up();
    }
    public static void gran_down() {
        left_down();
        midle_down();
        right_down();
    }
}
