   M S B A M L   `   `   `  ����D  @ExpenseIt, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:ExpenseIt	ExpenseIt  5          ExpenseIt.ExpenseItHome   5      \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      )localclr-namespace:ExpenseIt     5        N� Title$  ExpenseIt - Home��5	      .��5      �  � 	Resources 5   
      ExpenseDataSource � XPath  nameItemTemplate �� XPath��%�  &	        &	 =    � 5      $ Expenses��68   .��5      �
�	<Expenses xmlns="">
                        <Person Name="Sara Repeto García" Department="Jurídico">
                            <Expense ExpenseType="Comida" ExpenseAmount="50.00€" />
                            <Expense ExpenseType="Transporte" ExpenseAmount="50.00€" />
                        </Person>
                        <Person Name="Jose García Barrionuevo" Department="Marketing">
                            <Expense ExpenseType="Impresión documentos" ExpenseAmount="50.00€" />
                            <Expense ExpenseType="Regalo" ExpenseAmount="125.00€" />
                        </Person>
                        <Person Name="Pedro Rodríguez Gallego" Department="Ingeniería">
                            <Expense ExpenseType="Suscripción revista" ExpenseAmount="50.00€" />
                            <Expense ExpenseType="Nueva televisión" ExpenseAmount="600.00€" />
                            <Expense ExpenseType="Juego PC" ExpenseAmount="50.00€" />
                        </Person>
                        <Person Name="Eva María Marchena Mejías" Department="Finanzas">
                            <Expense ExpenseType="Cena" ExpenseAmount="100.00€" />
                        </Person>
                    </Expenses>        5$      �� 5'      .R�5(      �� ��6   �� $ @Name��5)      5+      ��5-   
   �� 5.       �� ImageSource$ fondoNuevo.jpg��6    � ColumnDefinitions 51   
   �� 52      $	��230 �6   �� 53       � RowDefinitions 56   
   �� 57      �� 58      $
��Auto �6   �� 59      �� 5:      $
��Auto �6   .+�5?   
   �� $��1��6     headerTextStyle#��[ 6    ���	#FFAE037F$��Century Gothic)�6`   .��6}   Ver informe de gastos5A      �� 5C   
   $��1��6   $��1��6!     listHeaderStyle#��[ 6.   ���	#FF953179$��0,0,17,0q�6n   ._�5D      ��   listHeaderTextStyle#��[ 6   $��Century Gothic)�6A   .��6]   	Nombres6f   5E      �� 5F   
   -   5        $��peopleListBox��5F      $��1��6'   $��2��67   #��[ 5H   
   $��	0,0,17,10q�6;   $��Century Gothic)�6N   ��5G   
   ��  �� Source# [  $ Person��5I      �� 5L   
   -   5        $��1��5L      $��3��6!     buttonStyle#��[ 6C   ���	#FF8D3273$��Century Gothic)�6   
�������$��	0,0,17,10q�6�   $	��108��6�   .��6�   Ver6�   �� 5M   
   $��0��6   $��0��6    $
��Left=�6-   $��76��6H   $	��Top=�6T   $��86��6l   $��logotipo.png��6w   $��	10,10,0,0q�6�   5N      5O      