

import com.eleodoro.biblioteca.conexao;
import java.sql.PrepareStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import BibliotecaDAO;


public class BibliotecaDAO{

    private Biblioteca biblioteca;
    private final String SQLINCLUIR = "INSERT INTO BIBLIOTECA VALUES (?, ?, ?)";
    private final String SQLALTERAR = "UPDATE ESTADO SET CAPACIDADE = ?, HORARIO = ? WHERE ID = ?";
    private final String SQLEXCLUIR = "DELETE FROM BIBLIOTECA WHERE ID = ?";
    private final String SQLCONSULTAR = "SELECT * FROM ESTADO WHERE ID = ?";

    public BibliotecaDAO (Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean incluir () {
        try {
            PreparedStatement ps = Conexao.getConexao () .PreparedStatement(SQLINCLUIR);
            ps.setInt(1, biblioteca.getId());
            ps.setInt(2, biblioteca.getNome());
            ps.setInt(3, biblioteca.getEmail());
            ps.setInt(3, biblioteca.getTelefone());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível incluir a biblioteca");
            return false;
        }
    }

    public boolean alterar () {
        try {
            PreparedStatement ps = Conexao.getConexao () .PreparedStatement(SQLALTERAR);
            ps.setInt(1, biblioteca.getNome());
            ps.setInt(2, biblioteca.getEmail());
            ps.setInt(3, biblioteca.getTelefone());
            ps.setInt(3, biblioteca.getInt());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível alterar a biblioteca");
            return false;
        }
    }

    public boolean consultar () {
        try {
            PreparedStatement ps = Conexao.getConexao () .PreparedStatement(SQLCONSULTAR);
            ps.setInt(1, biblioteca.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                biblioteca.setNome(rs.getInt(2));
                biblioteca.setEmail(rs.getInt(3));
            }
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não foi possível consultar a biblioteca");
            return false;
        }
    }
}