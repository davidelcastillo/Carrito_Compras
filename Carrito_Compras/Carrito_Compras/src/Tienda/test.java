package Tienda;
public class test {
    public static void main (String[] args) {
        clsArticulo art1 = new clsArticulo("remera","de expandex talle de s al xl","0000100",150,3);
        clsArticulo art2 = new clsArticulo("pantalon","de expandex talle de s al xl","0000101",200,2);
        clsArticulo art3 = new clsArticulo("campera","de jean talle de s al xl","0000103",250,2);
        
        clsUsuario user = new clsUsuario("xion20","123456", 1000, "Aregentina", "Salta");
        
        System.out.println (art1.getnombre());
        
        user.agregar_art(art1);
        user.agregar_art(art3);
        user.agregar_art (art2);
        
        user.menor_art();
        
        user.precio_art (1);
        
        user.quitar_art();
        
        user.getTotal();

        user.comprar(5);
    
    }

}