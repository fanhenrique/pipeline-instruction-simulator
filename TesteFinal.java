import javax.swing.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TesteFinal{

    public static void main(String[] args){

		Pipeline p = null;
		Leitor leitor = null;

		try{

			leitor = new Leitor(args[0]);

			leitor.le();

			p = new Pipeline();
			p.ordenaPipeline(leitor.getInstrucoes());

		}catch(FileNotFoundException e){
			System.out.println("Erro de arquivo");
		}catch(IOException e){
			System.out.println("Erro de leitura");
		}

		Tabela t = new Tabela(p.getBi(), p.getDi(), p.getEx(), p.getMem());

		Lista l = new Lista(leitor.getInstrucoes());

    	JPanel painel = new JPanel();

    	javax.swing.JButton jButton1;
    	javax.swing.JButton jButton2;
    	javax.swing.JScrollPane jScrollPane1;
    	javax.swing.JScrollPane jScrollPane2;
    	javax.swing.JSeparator jSeparator1;
     	javax.swing.JTable jTable1;
     	javax.swing.JTable jTable2;

    	jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        jButton1.setText("Sair");
        
		jButton2.setText("Pipeline");

        jScrollPane1.setViewportView(jTable1);

 		jTable2.setModel(l);
        jScrollPane2.setViewportView(jTable2);


        jButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});

		jButton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jTable1.setModel(t);						
			}
		});

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        JFrame janela = new JFrame("Pipeline");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.add(painel);
		janela.pack();	
		janela.setSize(600, 530);
		janela.setVisible(true);
    }
}