build:
	mkdir -p ./db/spring3-oracle-db
	mkdir -p ./db/spring3-rabbitmq-db
	mkdir -p ./db/spring3-redis-db
	docker compose build
up:
	docker compose up -d --remove-orphans
stop:
	docker compose stop
down:
	docker compose down
run:
	export JAVA_HOME=