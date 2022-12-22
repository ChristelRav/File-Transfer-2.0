# File-Transfer-2.0
transfert de fichier 2.0
Les CLASS :

==> InfoFile (Information du fichier envoyer : extension , type , nom)

==> MyClient (extend Thread)
          - sendMessage() [info file vers MyServer]
          - Tosend() [envoye le fivhier]
          - checkMessage [receptionne le fichier getter dans le serveur]
          - Toupload [reçoit le fichier upload-er]
         
==> MyServer (extend Thread)
          - getMessage [reçoit info fichier]
          - Toreceive [reçoit le fichier envoyer par MyClient]
          - shareMessage [partage les info de fichier vers MyClient]
          - Toshare [transfert le fichier aue le client a getter ]
          
** etc ..... : Interface graphique + video (VLC)
          
         
