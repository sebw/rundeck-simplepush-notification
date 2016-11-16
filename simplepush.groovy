import com.dtolabs.rundeck.plugins.notification.NotificationPlugin;
import groovy.text.SimpleTemplateEngine

rundeckPlugin(NotificationPlugin){
    title="Simplepush"
    description="Send a notification"

    configuration{
        simplepush_key (title:"Key", description: "Your Simplepush private key", required:true)
        simplepush_title (title:"Title", description: "Notification title", required:true)
	simplepush_message (title:"Message", description: "Notification message", required:true)
    }

    def shellCommand=['curl','--silent']

    def handleTrigger = {
        
        def command=new ArrayList(shellCommand)
		command<< 'https://api.simplepush.io/send/'+configuration.simplepush_key+'/'+configuration.simplepush_title+'/'+configuration.simplepush_message

        def proc = command.execute()
        proc.waitForProcessOutput(System.out,System.err)

        proc.exitValue()==0
    }

    onsuccess handleTrigger
    onfailure handleTrigger
    onstart handleTrigger
}
