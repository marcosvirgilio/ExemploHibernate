package hibernate;

import java.util.List;


public class Principal {
    public static void main(String[] args) {
        UsuarioPersistencia up = new UsuarioPersistencia();
        Usuario usr = new Usuario("Marcos Virgilio", "123", "marcosvirgilio@gmail.com");
        up.salvaUsuario(usr);
        usr = new Usuario("Fulano de Tal", "456", "fulano@gmail.com");
        up.salvaUsuario(usr);
        usr.setNome("Novo Fulano");
        up.atualizaUsuario(usr);
        //up.apagaUsuario(usr);
        // consulta
        Usuario uc = up.consultaUsuarioPorId(2);
        if (uc != null) {
        	System.out.println("consulta = " + uc.getNome());
        }
        List < Usuario > students = up.getUsuarios();
        for (Usuario s: students) {
         System.out.println(s.getNome());
        }
        
    }
}
