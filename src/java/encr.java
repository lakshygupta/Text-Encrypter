/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class encr extends HttpServlet {
    
    HashMap<String,String> encode=new HashMap<>();
      
     class Node implements Comparable<Node>{
        String data;
        Node left=null;
        Node right=null;

        int freq=0;

        Node(String data,int freq,Node left,Node right){
         this.data=data;
         this.freq=freq;
         this.left=left;
         this.right=right;
        }
        
        @Override
        public int compareTo(Node o){
            return this.freq - o.freq;
        }
    }
    
    void traverseTree(Node node,String ans){
          if(node.left==null && node.right==null){
            encode.put(node.data,ans);
            return;
          }

        traverseTree(node.left,ans+"0");
        traverseTree(node.right,ans+"1");

    }

    String encode(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String s=ch+"";
            
            String res=encode.get(s);
            sb.append(res);
        }
        return sb.toString();
    }

    void ht(String str)
    {
         int[] freq=new int[40];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                freq[27]++;
            }
            else if(str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' || str.charAt(i) == '4'
                    || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9')
                        freq[(str.charAt(i)-'0')+28]++;

            else 
             freq[str.charAt(i)-'a']++;
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                if(i==28)
                {
                    Node node=new Node('0' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==29)
                {
                    Node node=new Node('1' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==30)
                {
                    Node node=new Node('2' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==31)
                {
                    Node node=new Node('3' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==32)
                {
                    Node node=new Node('4' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==33)
                {
                    Node node=new Node('5' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==34)
                {
                    Node node=new Node('6' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==35)
                {
                    Node node=new Node('7' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==36)
                {
                    Node node=new Node('8' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else if(i==37)
                {
                    Node node=new Node('9' + "",freq[i],null,null); // not able to understand ask TA 
                    pq.add(node);
                    System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
                else{
                  Node node=new Node((char)(i+'a') + "",freq[i],null,null); // not able to understand ask TA
                  pq.add(node);
                  System.out.println(node.data + " -> " + node.freq); // prints the total words in the string along with their frequency
                }
            }
        }
        int idx=0;
        while(pq.size()!=1){
            Node one=pq.remove();
            Node two=pq.remove();

            Node node=new Node(one.data+two.data,one.freq+two.freq,one,two);
            pq.add(node);
            System.out.println("Merge String with freq add :- " + idx);
            System.out.println(node.data + " -> " + node.freq); //prints the merging of 2 least nodes whic are getting out from the string
            idx++;
        }
        
        traverseTree(pq.remove(),"");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd = request.getRequestDispatcher("encrypt.html");
                rd.include(request,response);
            String str;
            str = request.getParameter("encrypt");
            String to=request.getParameter("to");
            ht("asdgvajdvmnasvcamnsvcasdaskkkmmnmndbckasjbllllldcmanbeeeeeeeffffffhhhiioooooppqqrrrrrrrrrrrttuuuwwwwwxxxxxscmsanbcmsnbcmsnbcmsnbcdmdsncmsbcmsnbcskgymnszdcvmz||||||||cvn00011233344554455222566677736888999");
            String enc = encode(str);
            System.out.println(enc);
            SendMail.send(to, enc);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Encryption</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\" overflow-x:scroll;\n" +
"  overflow-y:hidden;\n" +
"  display: flex;\">");
            out.println("<h2 style=\"padding-left:4%;width:80%;\"><i>Your Message is encoded as : </i> <br>" + enc + "</h2>");
            out.println("</div>");
            out.println("<h2 style=\"padding-left:4%;\">Message Send successfully !!</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
