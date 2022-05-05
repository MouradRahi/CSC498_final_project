<?php
$api_url = 'https://api.quotable.io/random';
$quote = json_decode(file_get_contents($api_url));
echo $quote->content;
echo $quote->author;
?>