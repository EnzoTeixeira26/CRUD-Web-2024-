package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Usuario.Atividade;
import Usuario.Usuario;

public class UsuarioRepositorio {

    public ArrayList<Usuario> consultaUsuario(Usuario a) {
        ArrayList<Usuario> listaC = new ArrayList<>();
        try {
            String sql = "SELECT nome, email, senha FROM usuario";
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement p = connection.prepareStatement(sql)) {
                ResultSet rs = p.executeQuery();
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                    listaC.add(u);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta de usuarios");
            ex.printStackTrace();
        }
        return listaC;
    }

    public void salvarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement p = connection.prepareStatement(sql)) {
            p.setString(1, usuario.getNome());
            p.setString(2, usuario.getEmail());
            p.setString(3, usuario.getSenha());
            p.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar o usuário");
            ex.printStackTrace();
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement p = connection.prepareStatement(sql)) {
            p.setString(1, usuario.getNome());
            p.setString(2, usuario.getEmail());
            p.setString(3, usuario.getSenha());
            p.setInt(4, usuario.getId());
            p.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar usuário");
            ex.printStackTrace();
        }
    }

    public void deletarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuário com ID " + id + " deletado com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário com ID " + id + ".");
            e.printStackTrace();
        }
    }


    public Usuario autenticarUsuario(String email, String senha) {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement p = connection.prepareStatement(sql)) {
                p.setString(1, email);
                p.setString(2, senha);
                ResultSet rs = p.executeQuery();

                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro na autenticação de usuário");
            ex.printStackTrace();
        }
        return usuario;
    }

    public void registrarAtividade(int usuarioId, String acao) {
        String sql = "INSERT INTO atividades (usuario_id, acao) VALUES (?, ?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, usuarioId);
            p.setString(2, acao);
            p.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao registrar atividade");
            ex.printStackTrace();
        }
    }

    public ArrayList<Usuario> pesquisarUsuarios(String query) {
        ArrayList<Usuario> listaC = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuario WHERE nome LIKE ? OR email LIKE ?";
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement p = connection.prepareStatement(sql)) {
                p.setString(1, "%" + query + "%");
                p.setString(2, "%" + query + "%");
                ResultSet rs = p.executeQuery();

                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                    listaC.add(u);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro na pesquisa de usuários");
            ex.printStackTrace();
        }
        return listaC;
    }

    public Usuario consultarUsuarioPorId(int id) {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuario WHERE id = ?";
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement p = connection.prepareStatement(sql)) {
                p.setInt(1, id);
                ResultSet rs = p.executeQuery();

                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuário por ID");
            ex.printStackTrace();
        }
        return usuario;
    }

    public ArrayList<Usuario> consultarTodosUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try {
            String sql = "SELECT id, nome, email, senha FROM usuario";
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement p = connection.prepareStatement(sql)) {
                ResultSet rs = p.executeQuery();

                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    listaUsuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    

    public ArrayList<Atividade> buscarTodasAtividadesCompletas() {
        ArrayList<Atividade> atividades = new ArrayList<>();
        try {
            String sql = "SELECT a.usuario_id, a.acao, a.data_hora " +
                         "FROM atividades a " +
                         "JOIN usuario u ON a.usuario_id = u.id";
            try (Connection connection = ConnectionFactory.getConnection();
                 PreparedStatement p = connection.prepareStatement(sql)) {
                ResultSet rs = p.executeQuery();
                while (rs.next()) {
                    Atividade atividade = new Atividade();
                    atividade.setUsuarioId(rs.getInt("usuario_id"));
                    atividade.setAcao(rs.getString("acao"));
                    atividade.setDataHora(rs.getTimestamp("data_hora"));
                    atividades.add(atividade);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar atividades");
            ex.printStackTrace();
        }
        return atividades;
    }

}
