@WebServlet("/createRaca")
public class CR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obter os parâmetros da requisição
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String idt = request.getParameter("idt"); // Recebe o ID como String

Tipo tipo = null; // Objeto Tipo para associação
        try {
            int tipoId = Integer.parseInt(idt); // Converte o ID para inteiro
            // Usar o DAO para buscar o objeto Tipo pelo ID
            TipoDAO tipoDAO = new TipoDAO();
            Optional<Tipo> tipoOptional = tipoDAO.selectById(tipoId); // Método agora retorna um Optional

            // Verifica se o valor está presente dentro do Optional
            if (tipoOptional.isPresent()) {
                tipo = tipoOptional.get(); // Obtém o Tipo se presente
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tipo não encontrado");
                return;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do tipo inválido");
            return;
        }


        // Criar a instância de Raca
        Raca raca = new Raca();
        raca.setNome(nome);
        raca.setDescricao(descricao);
        raca.setTipo(tipo); // Configurar a associação com o Tipo

        // Salvar a Raca usando o DAO
        RacaDAO racaDAO = new RacaDAO();
        try {
            racaDAO.saverac(raca); // Método de salvar a raça

            // Responder ao cliente com confirmação
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Raça criada com sucesso!</h1>");
            response.getWriter().write("<p>Nome: " + nome + "</p>");
            response.getWriter().write("<p>Descrição: " + descricao + "</p>");
            response.getWriter().write("<p>Tipo: " + tipo.getId() + " - " + tipo.getNome() + "</p>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar a raça");
        }
    }
}
