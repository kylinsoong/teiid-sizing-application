/*
* JBoss, Home of Professional Open Source.
* See the COPYRIGHT.txt file distributed with this work for information
* regarding copyright ownership. Some portions may be licensed
* to Red Hat, Inc. under one or more contributor license agreements.
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
* 02110-1301 USA.
*/
package org.teiid.sizing;

public class TeiidUtils {
    
    public static final long ROW_SIZE = 1 << 8;
    public static final long KB = 1 << 10;
    public static final long MB = 1 << 20;
    
    public static final String LOGGING_CONTEXT = "org.teiid.sizing";
    
    public static final String TABEL_CREATE = "CREATE TABLE DESERIALIZETEST (COL_A CHAR(32), COL_B CHAR(32), COL_C CHAR(32), COL_D CHAR(32), COL_E CHAR(32), COL_F CHAR(32), COL_G CHAR(32), COL_H CHAR(32))";
    public static final String TABEL_INSERT = "INSERT INTO DESERIALIZETEST (COL_A, COL_B, COL_C, COL_D, COL_E, COL_F, COL_G, COL_H) VALUES (?,?,?,?,?,?,?,?)";
    
    public static String char32string() {
        return "";
    }
    
    private static final String TAB = "    ";
    private static final String COLON = ": ";
    
    private static final String TOOLS_SERIALIZATION = "serialization";
    private static final String TOOLS_DESERIALIZATION = "deserialization";

    public static void main(String[] args) throws Exception {

        if(args.length <= 0){
            usage();
        } else {
            String tool = args[0];
            String[] dest = new String[args.length -1];
            System.arraycopy(args, 1, dest, 0, dest.length);
            if(tool.equals(TOOLS_SERIALIZATION)) {
                Serialization.main(dest);
            } else if(tool.equals(TOOLS_DESERIALIZATION)) {
                Deserialization.main(dest);
            } else {
                usage();
            }
        }
    }

    private static void usage() {
        System.out.println("An sizing/profiling program must be given as the first argument.");
        System.out.println("Valid program names are:");
        System.out.println(TAB + TOOLS_SERIALIZATION + COLON + TeiidUtilsPlugin.Util.getString(TOOLS_SERIALIZATION));
        System.out.println(TAB + TOOLS_DESERIALIZATION + COLON + TeiidUtilsPlugin.Util.getString(TOOLS_DESERIALIZATION));
    }

}
