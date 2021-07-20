


# APICACAO DE TESTES PARA AVALIAR Binders/triggers e Azure/AWS

## Mapping com SQS: aws lambda create-event-source-mapping --function-name QuarkusHttpNativeFunction  --batch-size 10 --event-source-arn arn:aws:sqs:us-east-2:585849681126:arsenal

## aws lambda invoke --function-name QuarkusHttpNativeFunction --invocation-type Event  --cli-binary-format raw-in-base64-out  --payload '{"country":"Brazil"}' response.json

## Configurar a invocação assíncrona da função do Lambda do back-end: https://docs.aws.amazon.com/pt_br/apigateway/latest/developerguide/set-up-lambda-integration-async.html