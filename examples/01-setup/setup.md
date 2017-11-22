# Consul Setup

[consul.io](https://www.consul.io)  

## Local Setup
- Downloads  
[consul.io/downloads.html](https://www.consul.io/downloads.html)  
[consul 1.0.0 MAC OS X](https://releases.hashicorp.com/consul/1.0.0/consul_1.0.0_darwin_amd64.zip)  
[consul 1.0.0 Windows](https://releases.hashicorp.com/consul/1.0.0/consul_1.0.0_windows_amd64.zip)
[consul 1.0.0 Linux](https://releases.hashicorp.com/consul/1.0.0/consul_1.0.0_linux_amd64.zip)
- Linux command line:  
<code>
    curl \  
    https://releases.hashicorp.com/consul/1.0.0/consul\_1.0.0\_linux\_amd64.zip \  
     -o consul-1.0.0-linux-amd64.zip
</code>
- run script in separate shell to execute local binary instance under examples/01-setup/local assuming the binary has been renamed to consul in the local directory.  
<code>
    ./consul-binary-download.sh
    unzip consul_1.0.0_<platform>.zip
    mv consul_1.0.0_<platform> consul
    ./consul-start-local.sh
</code>

## Docker Setup

- Docker
 - [https://hub.docker.com/\_/consul/](https://hub.docker.com/_/consul/) 

### Using Startup Scripts 
 - run script in separate shell to execute a docker instance under examples/01-setup/docker .
 - two scripts exist, one for a swarm stack the other for simple docker engine

### Manual Startup Docker Engine  
<code>docker run -d \
	--name=dev-consul-01 \
	--net=host \
  	-e CONSUL_CLIENT_INTERFACE='eth1' \
  	-e CONSUL_BIND_INTERFACE='eth1' \
	-p 0.0.0.0:8300:8300 \
	-p 0.0.0.0:8301:8301 \
	-p 0.0.0.0:8302:8302 \
	-p 0.0.0.0:8400:8400 \
	-p 0.0.0.0:8500:8500 \
	-p 0.0.0.0:8600:8600 \
	consul:1.0.0 \
	agent \
	-server \
	-bootstrap-expect=1 \
	-ui
</code>

### Manual Startup Docker Swarm 
Using docker-compose.yml file under examples/01-setup/docker.

<code>docker stack deploy -c docker-compose.yml demo-consul
</code>

### Verify Setup
- open [http://localhost:8500/ui/](http://localhost:8500/ui/)
- add key / value
<code>  
./consul kv put config/timeouts/readTimeout 30000  
./consul kv get config/timeouts/readTimeout
</code>  
- refresh ui to see changed key / values
