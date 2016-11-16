# Rundeck Simplepush Notification

This Rundeck plugin permits notifications for [Simplepush](https://www.simplepush.io) notification service.

## Installation

- Make sure your Rundeck server has curl installed
- Place the groovy script under your Rundeck plugin directory (/var/lib/rundeck/libext/ on Redhat)  
- Restart Rundeck  
- Configure a notification

## Known Issues

- Doesn't support odd characters (ç,é,à) in title and message 
- Everyone gets to see your Simplepush private key
- Can't specify several private keys
