package VIEW;

import DAO.ClienteDAO;
import DAO.MotoDAO;
import DAO.VendaDAO;
import DTO.ClienteDTO;
import DTO.MotoDTO;
import DTO.VendaDTO;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel de Oliveira Santos
 */
public final class frmPrincipalVIEW extends javax.swing.JFrame {
    
    ArrayList<ClienteDTO> lista_cliente;
    ArrayList<MotoDTO> lista_moto;
    ArrayList<VendaDTO> lista_registro_venda;
    String modoCliente;
    String modoMoto;
    /**
     * Creates new form frmClienteVIEW
     */
    public frmPrincipalVIEW() {
        initComponents();
        setLocationRelativeTo(null); 
        c_cliente_id.setText("0");
        c_moto_id.setText("0");
        c_cliente_cpf_venda.setEnabled(false);
        c_cliente_nome_venda.setEnabled(false);
        c_cliente_telefone_venda.setEnabled(false);
        c_moto_placa_venda.setEnabled(false);
        c_moto_marca_venda.setEnabled(false);
        c_moto_modelo_venda.setEnabled(false);
        listarValoresCliente();
        listarValoresMoto();
        listarValoresVenda();
        modoCliente = "Navegar";
        modoMoto = "Navegar";
        ManipulaInterfaceCliente();
        ManipulaInterfaceMoto();
    }
    
    public void ManipulaInterfaceCliente() {
        switch(modoCliente){
            case "Navegar":
                btn_cliente_salvar.setEnabled(false);
                btn_cliente_cancelar.setEnabled(false);
                c_cliente_id.setEnabled(false);
                c_cliente_cpf.setEnabled(false);
                c_cliente_nome.setEnabled(false);
                c_cliente_telefone.setEnabled(false);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            
            case "Novo":
                btn_cliente_salvar.setEnabled(true);
                btn_cliente_cancelar.setEnabled(true);
                c_cliente_id.setEnabled(false);
                c_cliente_cpf.setEnabled(true);
                c_cliente_nome.setEnabled(true);
                c_cliente_telefone.setEnabled(true);
                btn_cliente_novo.setEnabled(false);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            
            case "Editar":
                btn_cliente_salvar.setEnabled(true);
                btn_cliente_cancelar.setEnabled(true);
                c_cliente_id.setEnabled(false);
                c_cliente_cpf.setEnabled(true);
                c_cliente_nome.setEnabled(true);
                c_cliente_telefone.setEnabled(true);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            
            case "Excluir":
                btn_cliente_salvar.setEnabled(false);
                btn_cliente_cancelar.setEnabled(false);
                c_cliente_id.setEnabled(false);
                c_cliente_cpf.setEnabled(false);
                c_cliente_nome.setEnabled(false);
                c_cliente_telefone.setEnabled(false);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(false);
                btn_cliente_excluir.setEnabled(false);
                break;
            
            case "Selecao":
                btn_cliente_salvar.setEnabled(false);
                btn_cliente_cancelar.setEnabled(false);
                c_cliente_id.setEnabled(false);
                c_cliente_cpf.setEnabled(false);
                c_cliente_nome.setEnabled(false);
                c_cliente_telefone.setEnabled(false);
                btn_cliente_novo.setEnabled(true);
                btn_cliente_editar.setEnabled(true);
                btn_cliente_excluir.setEnabled(true);
                break;
                
            default: System.out.println("Modo inválido");
        }
    }
    
    public void ManipulaInterfaceMoto() {
        switch(modoMoto){
            case "Navegar":
                btn_moto_salvar.setEnabled(false);
                btn_moto_cancelar.setEnabled(false);
                c_moto_id.setEnabled(false);
                c_moto_placa.setEnabled(false);
                cb_moto_modelo.setEnabled(false);
                cb_moto_marca.setEnabled(false);
                btn_moto_novo.setEnabled(true);
                btn_moto_editar.setEnabled(false);
                btn_moto_excluir.setEnabled(false);
                break;
            
            case "Novo":
                btn_moto_salvar.setEnabled(true);
                btn_moto_cancelar.setEnabled(true);
                c_moto_id.setEnabled(false);
                c_moto_placa.setEnabled(true);
                cb_moto_modelo.setEnabled(true);
                cb_moto_marca.setEnabled(true);
                btn_moto_novo.setEnabled(false);
                btn_moto_editar.setEnabled(false);
                btn_moto_excluir.setEnabled(false);
                break;
            
            case "Editar":
                btn_moto_salvar.setEnabled(true);
                btn_moto_cancelar.setEnabled(true);
                c_moto_id.setEnabled(false);
                c_moto_placa.setEnabled(true);
                cb_moto_modelo.setEnabled(true);
                cb_moto_marca.setEnabled(true);
                btn_moto_novo.setEnabled(true);
                btn_moto_editar.setEnabled(false);
                btn_moto_excluir.setEnabled(false);
                break;
            
            case "Excluir":
                btn_moto_salvar.setEnabled(false);
                btn_moto_cancelar.setEnabled(false);
                c_moto_id.setEnabled(false);
                c_moto_placa.setEnabled(false);
                cb_moto_modelo.setEnabled(false);
                cb_moto_marca.setEnabled(false);
                btn_moto_novo.setEnabled(true);
                btn_moto_editar.setEnabled(false);
                btn_moto_excluir.setEnabled(false);
                break;
            
            case "Selecao":
                btn_moto_salvar.setEnabled(false);
                btn_moto_cancelar.setEnabled(false);
                c_moto_id.setEnabled(false);
                c_moto_placa.setEnabled(false);
                cb_moto_modelo.setEnabled(false);
                cb_moto_marca.setEnabled(false);
                btn_moto_novo.setEnabled(true);
                btn_moto_editar.setEnabled(true);
                btn_moto_excluir.setEnabled(true);
                break;    
                
            default: System.out.println("Modo inválido");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_cliente_cpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        c_cliente_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_cliente_telefone = new javax.swing.JFormattedTextField();
        btn_cliente_salvar = new javax.swing.JButton();
        btn_cliente_cancelar = new javax.swing.JButton();
        c_cliente_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnPesquisarCliente = new javax.swing.JButton();
        btn_cliente_novo = new javax.swing.JButton();
        btn_cliente_editar = new javax.swing.JButton();
        btn_cliente_excluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cb_pesquisar_cliente = new javax.swing.JComboBox<>();
        c_valor_pesquisar_cliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaMoto = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_moto_salvar = new javax.swing.JButton();
        btn_moto_cancelar = new javax.swing.JButton();
        c_moto_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        c_moto_placa = new javax.swing.JTextField();
        cb_moto_marca = new javax.swing.JComboBox<>();
        cb_moto_modelo = new javax.swing.JComboBox<>();
        btnPesquisarMoto = new javax.swing.JButton();
        btn_moto_novo = new javax.swing.JButton();
        btn_moto_editar = new javax.swing.JButton();
        btn_moto_excluir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_pesquisar_moto = new javax.swing.JComboBox<>();
        c_valor_pesquisar_moto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_cliente_venda = new javax.swing.JTable();
        c_venda_cliente_pesquisa = new javax.swing.JTextField();
        btnPesquisarClienteVenda = new javax.swing.JButton();
        cb_venda_cliente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_moto_venda = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cb_venda_moto = new javax.swing.JComboBox<>();
        btnPesquisarMotoVenda = new javax.swing.JButton();
        c_venda_moto_pesquisa = new javax.swing.JTextField();
        btnEfetuarVenda = new javax.swing.JButton();
        btnCancelarVenda = new javax.swing.JButton();
        c_preco_venda = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        c_moto_modelo_venda = new javax.swing.JTextField();
        c_moto_marca_venda = new javax.swing.JTextField();
        labelNome3 = new javax.swing.JLabel();
        labelNome4 = new javax.swing.JLabel();
        c_moto_placa_venda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        c_cliente_telefone_venda = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        c_cliente_nome_venda = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        c_cliente_cpf_venda = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_registro_venda = new javax.swing.JTable();
        cb_pesquisa_venda = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        c_pesquisa_venda = new javax.swing.JTextField();
        btn_pesquisa_geral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "CPF", "Nome", "Telefone"
            }
        ));
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);
        if (tabelaCliente.getColumnModel().getColumnCount() > 0) {
            tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastro de Cliente"));

        jLabel1.setText("CPF");

        try {
            c_cliente_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Nome");

        jLabel2.setText("Telefone");

        try {
            c_cliente_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btn_cliente_salvar.setText("Salvar");
        btn_cliente_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_salvarActionPerformed(evt);
            }
        });

        btn_cliente_cancelar.setText("Cancelar");
        btn_cliente_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Id");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(btn_cliente_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_cliente_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2)
                        .addComponent(c_cliente_nome)
                        .addComponent(c_cliente_telefone, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(c_cliente_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(c_cliente_id, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addContainerGap(881, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_cliente_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_cliente_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c_cliente_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c_cliente_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cliente_salvar)
                    .addComponent(btn_cliente_cancelar))
                .addGap(27, 27, 27))
        );

        btnPesquisarCliente.setText("Pesquisar");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        btn_cliente_novo.setText("Novo");
        btn_cliente_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_novoActionPerformed(evt);
            }
        });

        btn_cliente_editar.setText("Editar");
        btn_cliente_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_editarActionPerformed(evt);
            }
        });

        btn_cliente_excluir.setText("Excluir");
        btn_cliente_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cliente_excluirActionPerformed(evt);
            }
        });

        jLabel6.setText("Pesquisar por:");

        cb_pesquisar_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Telefone" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_pesquisar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(c_valor_pesquisar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_cliente_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cliente_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cliente_excluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cb_pesquisar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPesquisarCliente)
                        .addComponent(c_valor_pesquisar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cliente_novo)
                    .addComponent(btn_cliente_editar)
                    .addComponent(btn_cliente_excluir))
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cliente", jPanel1);

        tabelaMoto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Placa", "Modelo", "Marca"
            }
        ));
        tabelaMoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMotoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaMoto);
        if (tabelaMoto.getColumnModel().getColumnCount() > 0) {
            tabelaMoto.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaMoto.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaMoto.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaMoto.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastro de Motocicleta"));

        jLabel4.setText("Placa");

        jLabel7.setText("Modelo");

        jLabel8.setText("Marca");

        btn_moto_salvar.setText("Salvar");
        btn_moto_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moto_salvarActionPerformed(evt);
            }
        });

        btn_moto_cancelar.setText("Cancelar");
        btn_moto_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moto_cancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("Id");

        cb_moto_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HONDA", "BMW", "YAMAHA", "DAFRA" }));
        cb_moto_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_moto_marcaActionPerformed(evt);
            }
        });

        cb_moto_modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BIZ", "POP 100", "CG 125", "CG 150", "NXR 150" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_moto_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_moto_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(c_moto_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(c_moto_id, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7)
                    .addComponent(cb_moto_modelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_moto_marca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_moto_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_moto_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_moto_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_moto_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_moto_salvar)
                    .addComponent(btn_moto_cancelar))
                .addGap(27, 27, 27))
        );

        btnPesquisarMoto.setText("Pesquisar");
        btnPesquisarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarMotoActionPerformed(evt);
            }
        });

        btn_moto_novo.setText("Novo");
        btn_moto_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moto_novoActionPerformed(evt);
            }
        });

        btn_moto_editar.setText("Editar");
        btn_moto_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moto_editarActionPerformed(evt);
            }
        });

        btn_moto_excluir.setText("Excluir");
        btn_moto_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moto_excluirActionPerformed(evt);
            }
        });

        jLabel10.setText("Pesquisar por:");

        cb_pesquisar_moto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Modelo", "Placa", "Marca" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_pesquisar_moto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(c_valor_pesquisar_moto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarMoto))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_moto_novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_moto_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_moto_excluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cb_pesquisar_moto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPesquisarMoto)
                        .addComponent(c_valor_pesquisar_moto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_moto_novo)
                    .addComponent(btn_moto_editar)
                    .addComponent(btn_moto_excluir))
                .addGap(22, 22, 22)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1175, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Moto", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Selecione o Cliente"));

        tbl_cliente_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "CPF", "Nome", "Telefone"
            }
        ));
        tbl_cliente_venda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cliente_vendaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_cliente_venda);

        btnPesquisarClienteVenda.setText("Pesquisar");
        btnPesquisarClienteVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteVendaActionPerformed(evt);
            }
        });

        cb_venda_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Telefone" }));

        jLabel11.setText("Pesquisar por:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_venda_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 637, Short.MAX_VALUE)
                        .addComponent(c_venda_cliente_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarClienteVenda))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_venda_cliente_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarClienteVenda)
                    .addComponent(cb_venda_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Selecione a Moto"));

        tbl_moto_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Placa", "Modelo", "Marca"
            }
        ));
        tbl_moto_venda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_moto_vendaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_moto_venda);

        jLabel12.setText("Pesquisar por:");

        cb_venda_moto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Modelo", "Placa", "Marca" }));

        btnPesquisarMotoVenda.setText("Pesquisar");
        btnPesquisarMotoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarMotoVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_venda_moto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(c_venda_moto_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarMotoVenda))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(c_venda_moto_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisarMotoVenda))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_venda_moto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnEfetuarVenda.setText("Efetuar Venda");
        btnEfetuarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfetuarVendaActionPerformed(evt);
            }
        });

        btnCancelarVenda.setText("Cancelar");

        jLabel14.setText("Modelo:");

        labelNome3.setText("Marca:");

        labelNome4.setText("Placa:");

        jLabel15.setText("Motocicleta Selecionada");

        jLabel16.setText("Telefone:");

        jLabel17.setText("Nome:");

        jLabel18.setText("CPF:");

        jLabel19.setText("Cliente Selecionado");

        jLabel20.setText("R$");

        jLabel21.setText("Valor Total (apenas números)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel17))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel19))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(c_cliente_cpf_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(c_cliente_nome_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(c_cliente_telefone_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNome3)
                                    .addComponent(labelNome4))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(c_moto_placa_venda)
                            .addComponent(c_moto_marca_venda)
                            .addComponent(c_moto_modelo_venda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(btnEfetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarVenda))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(c_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(231, 231, 231))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(c_cliente_cpf_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_cliente_nome_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(c_cliente_telefone_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_moto_modelo_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(c_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(c_moto_placa_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNome4))))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(c_moto_marca_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNome3)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEfetuarVenda)
                                    .addComponent(btnCancelarVenda))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Realizar Venda", jPanel6);

        tbl_registro_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Venda", "CPF", "Nome", "Telefone", "Placa", "Modelo", "Marca", "Preco", "Data da Venda"
            }
        ));
        jScrollPane5.setViewportView(tbl_registro_venda);
        if (tbl_registro_venda.getColumnModel().getColumnCount() > 0) {
            tbl_registro_venda.getColumnModel().getColumn(0).setPreferredWidth(1);
            tbl_registro_venda.getColumnModel().getColumn(1).setPreferredWidth(30);
            tbl_registro_venda.getColumnModel().getColumn(4).setPreferredWidth(20);
            tbl_registro_venda.getColumnModel().getColumn(5).setPreferredWidth(40);
            tbl_registro_venda.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        cb_pesquisa_venda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "Nome", "Telefone", "Placa", "Modelo", "Marca", "Preco", "Data da Venda" }));

        jLabel13.setText("Pesquisar por:");

        btn_pesquisa_geral.setText("Pesquisar");
        btn_pesquisa_geral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_geralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_pesquisa_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(c_pesquisa_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pesquisa_geral, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_pesquisa_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(c_pesquisa_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_geral))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro de Venda", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_moto_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moto_excluirActionPerformed
        String placa, modelo, marca;
        int id_moto;
        int btn_selecionado = JOptionPane.showConfirmDialog(null, "Excluir registro selecionado?", "Confirmação",JOptionPane.YES_NO_OPTION);

        modoMoto = "Excluir";

        id_moto = Integer.parseInt(c_moto_id.getText());
        placa = c_moto_placa.getText();
        modelo = String.valueOf(cb_moto_modelo.getSelectedItem());
        marca = String.valueOf(cb_moto_marca.getSelectedItem());

        MotoDTO objmotodto = new MotoDTO();

        objmotodto.setId_moto(id_moto);
        objmotodto.setPlaca(placa);
        objmotodto.setModelo(modelo);
        objmotodto.setMarca(marca);
        
        
        
        if (btn_selecionado == JOptionPane.YES_OPTION) {
            MotoDAO objmotodao = new MotoDAO();
            objmotodao.excluirMoto(objmotodto);
            JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
           
        }

        c_moto_id.setText("0");
        c_moto_placa.setText("");

        listarValoresMoto();
        ManipulaInterfaceMoto();
    }//GEN-LAST:event_btn_moto_excluirActionPerformed

    private void btn_moto_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moto_editarActionPerformed
        modoMoto = "Editar";
        ManipulaInterfaceMoto();
    }//GEN-LAST:event_btn_moto_editarActionPerformed

    private void btn_moto_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moto_novoActionPerformed
        modoMoto = "Novo";
        c_moto_id.setText("0");
        ManipulaInterfaceMoto();
    }//GEN-LAST:event_btn_moto_novoActionPerformed

    private void btnPesquisarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarMotoActionPerformed
        listarMotoPesquisa();
        c_valor_pesquisar_moto.setText("");
    }//GEN-LAST:event_btnPesquisarMotoActionPerformed

    private void btn_moto_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moto_cancelarActionPerformed
        c_moto_id.setText("0");
        c_moto_placa.setText("");

        modoMoto = "Navegar";
        ManipulaInterfaceMoto();
    }//GEN-LAST:event_btn_moto_cancelarActionPerformed

    private void btn_moto_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moto_salvarActionPerformed
        String placa, modelo, marca;
        int id_moto;

        id_moto = Integer.parseInt(c_moto_id.getText());
        placa = c_moto_placa.getText().toUpperCase();
        modelo = String.valueOf(cb_moto_modelo.getSelectedItem());
        marca = String.valueOf(cb_moto_marca.getSelectedItem());

        MotoDTO objmotodto = new MotoDTO();

        objmotodto.setId_moto(id_moto);
        objmotodto.setPlaca(placa);
        objmotodto.setModelo(modelo);
        objmotodto.setMarca(marca);

        if(modoMoto.equals("Novo")){
            try {
                if (placa.equals("") || placa.startsWith(" ") || marca.equals("") || modelo.equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    if (placa.length() == 7) {
                        MotoDAO objmotodao = new MotoDAO();
                        objmotodao.cadastrarMoto(objmotodto);
                    } else {
                        JOptionPane.showMessageDialog(null, "A placa deve conter apenas 7 caracteres!");
                    }   
                } 
            }
            
            catch (SQLException ex) {
                Logger.getLogger(frmPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(modoMoto.equals("Editar")){
            if (placa.equals("") || placa.startsWith(" ") || marca.equals("") || modelo.equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                if (placa.length() == 7) {
                    MotoDAO objmotodao = new MotoDAO();
                    objmotodao.editarMoto(objmotodto);
                
                } else {
                    JOptionPane.showMessageDialog(null, "A placa deve conter apenas 7 caracteres!");
                }
            }
        }

        c_moto_id.setText("0");
        c_moto_placa.setText("");
        c_cliente_cpf_venda.setText("");
        c_cliente_nome_venda.setText("");
        c_cliente_telefone_venda.setText("");
        c_moto_placa_venda.setText("");
        c_moto_marca_venda.setText("");
        c_moto_modelo_venda.setText("");
        
        listarValoresMoto();
        ManipulaInterfaceMoto();
    }//GEN-LAST:event_btn_moto_salvarActionPerformed

    private void tabelaMotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMotoMouseClicked

        int index = tabelaMoto.getSelectedRow();

        if(index >= 0 && index < lista_moto.size()){
            MotoDTO M = lista_moto.get(index);
            c_moto_id.setText(String.valueOf(M.getId_moto()));
            c_moto_placa.setText(M.getPlaca());
            cb_moto_modelo.setSelectedItem(String.valueOf(M.getModelo()));
            cb_moto_marca.setSelectedItem(String.valueOf(M.getMarca()));

            modoMoto = "Selecao";
            ManipulaInterfaceMoto();
        }
    }//GEN-LAST:event_tabelaMotoMouseClicked

    private void btn_cliente_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_excluirActionPerformed
        String cpf, nome_cliente, nascimento_cliente;
        int id_cliente;
        int btn_selecionado = JOptionPane.showConfirmDialog(null, "Excluir registro selecionado?", "Confirmação",JOptionPane.YES_NO_OPTION);

        modoCliente = "Excluir";

        id_cliente = Integer.parseInt(c_cliente_id.getText());
        cpf = c_cliente_cpf.getText();
        nome_cliente = c_cliente_nome.getText();
        nascimento_cliente = c_cliente_telefone.getText();

        ClienteDTO objclientedto = new ClienteDTO();

        objclientedto.setId_cliente(id_cliente);
        objclientedto.setCpf(cpf);
        objclientedto.setNome_cliente(nome_cliente);
        objclientedto.setTelefone(nascimento_cliente);
        
        if (btn_selecionado == JOptionPane.YES_OPTION) {   
            ClienteDAO objclientedao = new ClienteDAO();
            objclientedao.excluirCliente(objclientedto);
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
        }
        
        c_cliente_id.setText("0");
        c_cliente_cpf.setText("");
        c_cliente_nome.setText("");
        c_cliente_telefone.setText("");

        listarValoresCliente();
        ManipulaInterfaceCliente();      
    }//GEN-LAST:event_btn_cliente_excluirActionPerformed

    private void btn_cliente_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_editarActionPerformed
        modoCliente = "Editar";
        ManipulaInterfaceCliente();
    }//GEN-LAST:event_btn_cliente_editarActionPerformed

    private void btn_cliente_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_novoActionPerformed
        modoCliente = "Novo";
        c_cliente_id.setText("0");
        ManipulaInterfaceCliente();
    }//GEN-LAST:event_btn_cliente_novoActionPerformed

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        listarClientePesquisa();
        c_valor_pesquisar_cliente.setText("");
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btn_cliente_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_cancelarActionPerformed
        c_cliente_id.setText("0");
        c_cliente_cpf.setText("");
        c_cliente_nome.setText("");
        c_cliente_telefone.setText("");

        modoCliente = "Navegar";
        ManipulaInterfaceCliente();
    }//GEN-LAST:event_btn_cliente_cancelarActionPerformed

    private void btn_cliente_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cliente_salvarActionPerformed
        String cpf, nome_cliente, telefone;
        int id_cliente;

        id_cliente = Integer.parseInt(c_cliente_id.getText());
        cpf = c_cliente_cpf.getText();
        nome_cliente = c_cliente_nome.getText().toUpperCase();
        telefone = c_cliente_telefone.getText();

        ClienteDTO objclientedto = new ClienteDTO();

        objclientedto.setId_cliente(id_cliente);
        objclientedto.setCpf(cpf);
        objclientedto.setNome_cliente(nome_cliente);
        objclientedto.setTelefone(telefone);

        if(modoCliente.equals("Novo")){
            try {
                if (cpf.endsWith(" ") || nome_cliente.equals("") || telefone.endsWith(" ") || cpf.startsWith(" ") || nome_cliente.startsWith(" ") || telefone.startsWith(" ")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                } else {
                    ClienteDAO objclientedao = new ClienteDAO();
                    objclientedao.cadastrarCliente(objclientedto);
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if(modoCliente.equals("Editar")){
            if (cpf.endsWith(" ") || nome_cliente.equals("") || telefone.endsWith(" ") || cpf.startsWith(" ") || nome_cliente.startsWith(" ") || telefone.startsWith(" ")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
            } else {
                ClienteDAO objclientedao = new ClienteDAO();
                objclientedao.editarCliente(objclientedto);
            }
        }

        c_cliente_id.setText("0");
        c_cliente_cpf.setText("");
        c_cliente_nome.setText("");
        c_cliente_telefone.setText("");
        c_cliente_cpf_venda.setText("");
        c_cliente_nome_venda.setText("");
        c_cliente_telefone_venda.setText("");
        c_moto_placa_venda.setText("");
        c_moto_marca_venda.setText("");
        c_moto_modelo_venda.setText("");

        listarValoresCliente();
        ManipulaInterfaceCliente();

    }//GEN-LAST:event_btn_cliente_salvarActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        int index = tabelaCliente.getSelectedRow();

        if(index >= 0 && index < lista_cliente.size()){
            ClienteDTO C = lista_cliente.get(index);
            c_cliente_id.setText(String.valueOf(C.getId_cliente()));
            c_cliente_cpf.setText(C.getCpf());
            c_cliente_nome.setText(C.getNome_cliente());
            c_cliente_telefone.setText(C.getTelefone());

            modoCliente = "Selecao";
            ManipulaInterfaceCliente();
        }
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void tbl_cliente_vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cliente_vendaMouseClicked
        int index = tbl_cliente_venda.getSelectedRow();

        if(index >= 0 && index < lista_cliente.size()) {
            ClienteDTO C = lista_cliente.get(index);
            c_cliente_cpf_venda.setText(C.getCpf());
            c_cliente_nome_venda.setText(C.getNome_cliente());
            c_cliente_telefone_venda.setText(C.getTelefone());
            ManipulaInterfaceCliente();
        }
    }//GEN-LAST:event_tbl_cliente_vendaMouseClicked

    private void tbl_moto_vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_moto_vendaMouseClicked
        int index = tbl_moto_venda.getSelectedRow();

        if(index >= 0 && index < lista_moto.size()) {
            MotoDTO M = lista_moto.get(index);
            c_moto_placa_venda.setText(M.getPlaca());
            c_moto_marca_venda.setText(M.getMarca());
            c_moto_modelo_venda.setText(M.getModelo());
            ManipulaInterfaceMoto();
        }
    }//GEN-LAST:event_tbl_moto_vendaMouseClicked

    private void btnEfetuarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfetuarVendaActionPerformed
        if(c_preco_venda.getText().equals("") || 
           c_cliente_cpf_venda.getText().equals("") || 
           c_cliente_nome_venda.getText().equals("") || 
           c_cliente_telefone_venda.getText().equals("") || 
           c_moto_placa_venda.getText().equals("") || 
           c_moto_marca_venda.getText().equals("") || 
           c_moto_modelo_venda.getText().equals("")
           ) {
            
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
        
            int index = tbl_cliente_venda.getSelectedRow();
            int index2 = tbl_moto_venda.getSelectedRow();
            String preco = NumberFormat.getCurrencyInstance().format(Integer.parseInt(c_preco_venda.getText()));
            String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

            VendaDAO objvendadao = new VendaDAO();
            MotoDAO objmotodaovenda = new MotoDAO();

            if(index >= 0 && index < lista_cliente.size() && index2 >= 0 && index2 < lista_moto.size()){
                ClienteDTO objclientedto = lista_cliente.get(index);
                MotoDTO objmotodto = lista_moto.get(index2);
                VendaDTO objvendadto = new VendaDTO();

                objvendadto.setCpf_venda(objclientedto.getCpf());
                objvendadto.setNome_cliente_venda(objclientedto.getNome_cliente());
                objvendadto.setTelefone_venda(objclientedto.getTelefone());
                objvendadto.setPlaca_venda(objmotodto.getPlaca());
                objvendadto.setModelo_venda(objmotodto.getModelo());
                objvendadto.setPreco_moto(preco);
                objvendadto.setMarca_venda(objmotodto.getMarca());
                objvendadto.setData_venda(data);

                try {
                    int btn_selecionado = JOptionPane.showConfirmDialog(null, "Efetuar Venda?" + 
                                "\n\nCliente: " + objclientedto.getNome_cliente() + 
                                "\nMotocicleta: " + objmotodto.getMarca() + " " + objmotodto.getModelo() + 
                                "\nValor: " + objvendadto.getPreco_moto() + "\n", 
                                "Confirmação",JOptionPane.YES_NO_OPTION);
        
                    if (btn_selecionado == JOptionPane.YES_OPTION) {
                        objvendadao.registrarVenda(objvendadto);
                        objmotodaovenda.excluirMoto(objmotodto);

                        listarValoresMoto();
                        listarValoresVenda();

                        JOptionPane.showMessageDialog(null, 
                                "Venda Efetuada com sucesso." + 
                                "\n\nCliente: " + objclientedto.getNome_cliente() + 
                                "\nMotocicleta: " + objmotodto.getMarca() + " " + objmotodto.getModelo() + 
                                "\nValor: " + objvendadto.getPreco_moto() + "\n");
                        
                        c_cliente_cpf_venda.setText("");
                        c_cliente_nome_venda.setText("");
                        c_cliente_telefone_venda.setText("");
                        c_moto_placa_venda.setText("");
                        c_moto_marca_venda.setText("");
                        c_moto_modelo_venda.setText("");
                        c_preco_venda.setText("");
                    }

                }               
                
                catch (SQLException ex) {
                    Logger.getLogger(frmPrincipalVIEW.class.getName()).log(Level.SEVERE, null, ex);
                }
                              
            }                   
        }
    }//GEN-LAST:event_btnEfetuarVendaActionPerformed

    private void btnPesquisarClienteVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteVendaActionPerformed
        listarClientePesquisaVenda();
        c_venda_cliente_pesquisa.setText("");
    }//GEN-LAST:event_btnPesquisarClienteVendaActionPerformed

    private void btnPesquisarMotoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarMotoVendaActionPerformed
        listarMotoPesquisaVenda();
        c_venda_moto_pesquisa.setText("");
    }//GEN-LAST:event_btnPesquisarMotoVendaActionPerformed

    private void cb_moto_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_moto_marcaActionPerformed
        switch(String.valueOf(cb_moto_marca.getSelectedItem())){
            case "HONDA":
                cb_moto_modelo.removeAllItems();
                cb_moto_modelo.addItem("BIZ");
                cb_moto_modelo.addItem("POP 100");
                cb_moto_modelo.addItem("CG 125");
                cb_moto_modelo.addItem("CG 150");
                cb_moto_modelo.addItem("NXR 150");

                break;
            
            case "BMW":
                cb_moto_modelo.removeAllItems();
                cb_moto_modelo.addItem("C 650 GT");
                cb_moto_modelo.addItem("R 1250 GS");
                cb_moto_modelo.addItem("F 850 GS");
                cb_moto_modelo.addItem("F 750 GS");
                cb_moto_modelo.addItem("G 310 GS");               
                break;
            
            case "YAMAHA":
                cb_moto_modelo.removeAllItems();
                cb_moto_modelo.addItem("CRYPTON 105");
                cb_moto_modelo.addItem("DT 200");
                cb_moto_modelo.addItem("FAZER 600");
                cb_moto_modelo.addItem("FAZER 250");
                cb_moto_modelo.addItem("FACTOR 125");
                break;
                
            case "DAFRA":
                cb_moto_modelo.removeAllItems();
                cb_moto_modelo.addItem("APACHE 150");
                cb_moto_modelo.addItem("APACHE 200");
                cb_moto_modelo.addItem("CITYCLASS 200I");
                cb_moto_modelo.addItem("FIDDLE III");
                cb_moto_modelo.addItem("HORIZON 250");
                break;
        }
    }//GEN-LAST:event_cb_moto_marcaActionPerformed

    private void btn_pesquisa_geralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_geralActionPerformed
        listarPesquisaGeralVenda();
        c_pesquisa_venda.setText("");
    }//GEN-LAST:event_btn_pesquisa_geralActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipalVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenda;
    private javax.swing.JButton btnEfetuarVenda;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarClienteVenda;
    private javax.swing.JButton btnPesquisarMoto;
    private javax.swing.JButton btnPesquisarMotoVenda;
    private javax.swing.JButton btn_cliente_cancelar;
    private javax.swing.JButton btn_cliente_editar;
    private javax.swing.JButton btn_cliente_excluir;
    private javax.swing.JButton btn_cliente_novo;
    private javax.swing.JButton btn_cliente_salvar;
    private javax.swing.JButton btn_moto_cancelar;
    private javax.swing.JButton btn_moto_editar;
    private javax.swing.JButton btn_moto_excluir;
    private javax.swing.JButton btn_moto_novo;
    private javax.swing.JButton btn_moto_salvar;
    private javax.swing.JButton btn_pesquisa_geral;
    private javax.swing.JFormattedTextField c_cliente_cpf;
    private javax.swing.JTextField c_cliente_cpf_venda;
    private javax.swing.JTextField c_cliente_id;
    private javax.swing.JTextField c_cliente_nome;
    private javax.swing.JTextField c_cliente_nome_venda;
    private javax.swing.JFormattedTextField c_cliente_telefone;
    private javax.swing.JTextField c_cliente_telefone_venda;
    private javax.swing.JTextField c_moto_id;
    private javax.swing.JTextField c_moto_marca_venda;
    private javax.swing.JTextField c_moto_modelo_venda;
    private javax.swing.JTextField c_moto_placa;
    private javax.swing.JTextField c_moto_placa_venda;
    private javax.swing.JTextField c_pesquisa_venda;
    private javax.swing.JTextField c_preco_venda;
    private javax.swing.JTextField c_valor_pesquisar_cliente;
    private javax.swing.JTextField c_valor_pesquisar_moto;
    private javax.swing.JTextField c_venda_cliente_pesquisa;
    private javax.swing.JTextField c_venda_moto_pesquisa;
    private javax.swing.JComboBox<String> cb_moto_marca;
    private javax.swing.JComboBox<String> cb_moto_modelo;
    private javax.swing.JComboBox<String> cb_pesquisa_venda;
    private javax.swing.JComboBox<String> cb_pesquisar_cliente;
    private javax.swing.JComboBox<String> cb_pesquisar_moto;
    private javax.swing.JComboBox<String> cb_venda_cliente;
    private javax.swing.JComboBox<String> cb_venda_moto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelNome3;
    private javax.swing.JLabel labelNome4;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTable tabelaMoto;
    private javax.swing.JTable tbl_cliente_venda;
    private javax.swing.JTable tbl_moto_venda;
    private javax.swing.JTable tbl_registro_venda;
    // End of variables declaration//GEN-END:variables

    private void listarValoresCliente() {
        
        try {
            String cpf;
            cpf = c_cliente_cpf.getText();
            ClienteDAO objclientedao = new ClienteDAO();   
            ClienteDTO objclientedto = new ClienteDTO();
        
            objclientedto.setCpf(cpf);
            
            DefaultTableModel model_cliente = (DefaultTableModel) tabelaCliente.getModel();
            model_cliente.setNumRows(0);
            
            DefaultTableModel model_cliente_venda = (DefaultTableModel) tbl_cliente_venda.getModel();
            model_cliente_venda.setNumRows(0);
            
            lista_cliente = objclientedao.pesquisarCliente();
            
            for(int i = 0; i < lista_cliente.size(); ++i){
                model_cliente.addRow(new Object[]{
                    lista_cliente.get(i).getId_cliente(),
                    lista_cliente.get(i).getCpf(),
                    lista_cliente.get(i).getNome_cliente(),
                    lista_cliente.get(i).getTelefone()
                });
            }
            
            for(int i = 0; i < lista_cliente.size(); ++i){
                model_cliente_venda.addRow(new Object[]{
                    lista_cliente.get(i).getId_cliente(),
                    lista_cliente.get(i).getCpf(),
                    lista_cliente.get(i).getNome_cliente(),
                    lista_cliente.get(i).getTelefone()
                });
            }  
        
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }
    
    private void listarClientePesquisa() {
        try {
            String valorDigitado;
            String coluna = "";
            valorDigitado = '%' + c_valor_pesquisar_cliente.getText() + '%';         
            
            ClienteDAO objclientedao = new ClienteDAO();        
            ClienteDTO objclientedto = new ClienteDTO();
            
            DefaultTableModel model = (DefaultTableModel) tabelaCliente.getModel();
            model.setNumRows(0);
            
            if(cb_pesquisar_cliente.getSelectedItem().equals("Nome")){
                coluna = "nome";
                objclientedto.setNome_cliente(valorDigitado);
            }
            else if(cb_pesquisar_cliente.getSelectedItem().equals("CPF")){
                coluna = "cpf";
                objclientedto.setCpf(valorDigitado);
            }
            else if(cb_pesquisar_cliente.getSelectedItem().equals("Telefone")){
                coluna = "telefone";
                objclientedto.setTelefone(valorDigitado);
            }
            
            lista_cliente = objclientedao.buscarCliente(coluna, objclientedto);
         
            for(int i = 0; i < lista_cliente.size(); ++i){
                model.addRow(new Object[]{
                    lista_cliente.get(i).getId_cliente(),
                    lista_cliente.get(i).getCpf(),
                    lista_cliente.get(i).getNome_cliente(),
                    lista_cliente.get(i).getTelefone()
                });
            }      
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }
    
    private void listarClientePesquisaVenda() {
        try {
            String valorDigitado;
            String coluna = "";
            valorDigitado = '%' + c_venda_cliente_pesquisa.getText() + '%';         
            
            ClienteDAO objclientedao = new ClienteDAO();        
            ClienteDTO objclientedto = new ClienteDTO();
            
            DefaultTableModel model = (DefaultTableModel) tbl_cliente_venda.getModel();
            model.setNumRows(0);
            
            if(cb_venda_cliente.getSelectedItem().equals("Nome")){
                coluna = "nome";
                objclientedto.setNome_cliente(valorDigitado);
            }
            else if(cb_venda_cliente.getSelectedItem().equals("CPF")){
                coluna = "cpf";
                objclientedto.setCpf(valorDigitado);
            }
            else if(cb_venda_cliente.getSelectedItem().equals("Telefone")){
                coluna = "telefone";
                objclientedto.setTelefone(valorDigitado);
            }
            
            lista_cliente = objclientedao.buscarCliente(coluna, objclientedto);
         
            for(int i = 0; i < lista_cliente.size(); ++i){
                model.addRow(new Object[]{
                    lista_cliente.get(i).getId_cliente(),
                    lista_cliente.get(i).getCpf(),
                    lista_cliente.get(i).getNome_cliente(),
                    lista_cliente.get(i).getTelefone()
                });
            }      
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }
    
    private void listarValoresMoto() {
        
        try {
            String placa;
            placa = c_moto_placa.getText();
            MotoDAO objmotodao = new MotoDAO();   
            MotoDTO objmotodto = new MotoDTO();
            
            objmotodto.setPlaca(placa);
            
            DefaultTableModel model_moto = (DefaultTableModel) tabelaMoto.getModel();
            model_moto.setNumRows(0);
            
            DefaultTableModel model_moto_venda = (DefaultTableModel) tbl_moto_venda.getModel();
            model_moto_venda.setNumRows(0);

            
            lista_moto = objmotodao.pesquisarMoto();
            
            for(int i = 0; i < lista_moto.size(); ++i){
                model_moto.addRow(new Object[]{
                    lista_moto.get(i).getId_moto(),
                    lista_moto.get(i).getPlaca(),
                    lista_moto.get(i).getModelo(),
                    lista_moto.get(i).getMarca()
                });
            }
            
            for(int i = 0; i < lista_moto.size(); ++i){
                model_moto_venda.addRow(new Object[]{
                    lista_moto.get(i).getId_moto(),
                    lista_moto.get(i).getPlaca(),
                    lista_moto.get(i).getModelo(),
                    lista_moto.get(i).getMarca()
                });
            }
            
        
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }
    
    private void listarMotoPesquisa() {
        try {
            String valorDigitado;
            String coluna = "";
            valorDigitado = '%' + c_valor_pesquisar_moto.getText() + '%';         
            
            MotoDAO objmotodao = new MotoDAO();        
            MotoDTO objmotodto = new MotoDTO();
            
            DefaultTableModel model = (DefaultTableModel) tabelaMoto.getModel();
            model.setNumRows(0);
            
            if(cb_pesquisar_moto.getSelectedItem().equals("Modelo")){
                coluna = "modelo";
                objmotodto.setModelo(valorDigitado);
            }
            else if(cb_pesquisar_moto.getSelectedItem().equals("Placa")){
                coluna = "placa";
                objmotodto.setPlaca(valorDigitado);
            }
            else if(cb_pesquisar_moto.getSelectedItem().equals("Marca")){
                coluna = "marca";
                objmotodto.setMarca(valorDigitado);
            }
            
            lista_moto = objmotodao.buscarMoto(coluna, objmotodto);
         
            for(int i = 0; i < lista_moto.size(); ++i){
                model.addRow(new Object[]{
                    lista_moto.get(i).getId_moto(),
                    lista_moto.get(i).getPlaca(),
                    lista_moto.get(i).getModelo(),
                    lista_moto.get(i).getMarca()
                });
            }      
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }
    
    private void listarMotoPesquisaVenda() {
        try {
            String valorDigitado;
            String coluna = "";
            valorDigitado = '%' + c_venda_moto_pesquisa.getText() + '%';         
            
            MotoDAO objmotodao = new MotoDAO();        
            MotoDTO objmotodto = new MotoDTO();
            
            DefaultTableModel model = (DefaultTableModel) tbl_moto_venda.getModel();
            model.setNumRows(0);
            
            if(cb_venda_moto.getSelectedItem().equals("Modelo")){
                coluna = "modelo";
                objmotodto.setModelo(valorDigitado);
            }
            else if(cb_venda_moto.getSelectedItem().equals("Placa")){
                coluna = "placa";
                objmotodto.setPlaca(valorDigitado);
            }
            else if(cb_venda_moto.getSelectedItem().equals("Marca")){
                coluna = "marca";
                objmotodto.setMarca(valorDigitado);
            }
            
            lista_moto = objmotodao.buscarMoto(coluna, objmotodto);
         
            for(int i = 0; i < lista_moto.size(); ++i){
                model.addRow(new Object[]{
                    lista_moto.get(i).getId_moto(),
                    lista_moto.get(i).getPlaca(),
                    lista_moto.get(i).getModelo(),
                    lista_moto.get(i).getMarca()
                });
            }      
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }
    
    private void listarValoresVenda() {
        
        try {           
            VendaDAO objvendadao = new VendaDAO();
                        
            DefaultTableModel model_registro_venda = (DefaultTableModel) tbl_registro_venda.getModel();
            model_registro_venda.setNumRows(0);
          
            lista_registro_venda = objvendadao.pesquisarVenda();
            
            for(int i = 0; i < lista_registro_venda.size(); ++i){
                model_registro_venda.addRow(new Object[]{
                    lista_registro_venda.get(i).getId_venda(),
                    lista_registro_venda.get(i).getCpf_venda(),
                    lista_registro_venda.get(i).getNome_cliente_venda(),
                    lista_registro_venda.get(i).getTelefone_venda(),
                    lista_registro_venda.get(i).getPlaca_venda(),
                    lista_registro_venda.get(i).getModelo_venda(),
                    lista_registro_venda.get(i).getMarca_venda(),
                    lista_registro_venda.get(i).getPreco_moto(),
                    lista_registro_venda.get(i).getData_venda()
                });
            }
        
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }
    
    private void listarPesquisaGeralVenda() {
        try {
            String valorDigitado;
            String coluna = "";
            valorDigitado = '%' + c_pesquisa_venda.getText() + '%';         
            
            VendaDAO objvendadao = new VendaDAO();        
            VendaDTO objvendadto = new VendaDTO();
            
            DefaultTableModel model = (DefaultTableModel) tbl_registro_venda.getModel();
            model.setNumRows(0);
            
            if(cb_pesquisa_venda.getSelectedItem().equals("CPF")){
                coluna = "cpf";
                objvendadto.setCpf_venda(valorDigitado);
            }
            else if(cb_pesquisa_venda.getSelectedItem().equals("Nome")){
                coluna = "nome_cliente";
                objvendadto.setNome_cliente_venda(valorDigitado);
            }
            else if(cb_pesquisa_venda.getSelectedItem().equals("Telefone")){
                coluna = "telefone";
                objvendadto.setTelefone_venda(valorDigitado);
            }
            else if(cb_pesquisa_venda.getSelectedItem().equals("Placa")){
                coluna = "placa";
                objvendadto.setPlaca_venda(valorDigitado);
            }
            else if(cb_pesquisa_venda.getSelectedItem().equals("Modelo")){
                coluna = "modelo";
                objvendadto.setModelo_venda(valorDigitado);
            }
            else if(cb_pesquisa_venda.getSelectedItem().equals("Marca")){
                coluna = "marca";
                objvendadto.setMarca_venda(valorDigitado);
            }
            else if(cb_pesquisa_venda.getSelectedItem().equals("Preço")){
                coluna = "preco";
                objvendadto.setPreco_moto(valorDigitado);
            }
            else if(cb_pesquisa_venda.getSelectedItem().equals("Data da Venda")){
                coluna = "dt_venda";
                objvendadto.setData_venda(valorDigitado);
            }
            
            
            lista_registro_venda = objvendadao.buscarVenda(coluna, objvendadto);
         
            for(int i = 0; i < lista_registro_venda.size(); ++i){
                model.addRow(new Object[]{
                    lista_registro_venda.get(i).getId_venda(),
                    lista_registro_venda.get(i).getCpf_venda(),
                    lista_registro_venda.get(i).getNome_cliente_venda(),
                    lista_registro_venda.get(i).getTelefone_venda(),
                    lista_registro_venda.get(i).getPlaca_venda(),
                    lista_registro_venda.get(i).getModelo_venda(),
                    lista_registro_venda.get(i).getMarca_venda(),
                    lista_registro_venda.get(i).getPreco_moto(),
                    lista_registro_venda.get(i).getData_venda()
                });
            }      
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "listarValores VIEW " + erro);
        }
    }

}



